/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cumimpactsa;

import java.util.ArrayList;

/**
 * @summary A regular grid for mapping.
 * @author ast
 */
public class MappingGrid 
{
    private double worldLeft= (double) 9999999999.0;
    private double worldRight= (double) -999999999.0;
    private double worldTop= (double) -999999999.0;
    private double worldBottom= (double) 999999999.0;
    private double cellsize= (double) 999999999.0;
    
    private double xDimWorld=-1;
    private double yDimWorld=-1;
    private int xCells=-1;
    private int yCells=-1;
   
    double[] worldX;
    double[] worldY;
    
    private double[][] emptyGrid=null; //contains only no data and 0

    public MappingGrid(double[] x, double[] y)
    {
        
        worldX=x;
        worldY=y;

        
        //select three points - first, last, middle in list - for smallest distance (should correspond to cell size)
        double x1=x[0]; double x2=x[(int) (x.length/2)]; double x3=x[x.length-2];
        double y1=y[0]; double y2=y[(int) (y.length/2)]; double y3=y[y.length-2];
        
        //find min and max x and y world coordinates
        for(int i=0; i<x.length;i++)
        {   
            //get world dimensions
            if(x[i]<worldLeft) {worldLeft=x[i];}
            if(x[i]>worldRight) {worldRight=x[i];}
            if(y[i]<worldBottom) {worldBottom=y[i];}
            if(y[i]>worldTop) {worldTop=y[i];}
              
        }
        
            //get cell size by comparing distance between three pre-selected cells with the current one. 
            //Smallest distance in either x or y direction found is taken to be cell size
            for(int i=0; i<x.length;i++)
            {   
                if(Math.abs(x[i]-x1)<cellsize && Math.abs(x[i]-x1)!=0) 
                    {cellsize = (double) Math.abs(x[i]-x1);System.out.println("i: "+i+"; x1: "+x1 + "; xi: "+x[i]+"; New cellsize: "+cellsize);}
                if(Math.abs(x[i]-x2)<cellsize && Math.abs(x[i]-x2)!=0) 
                    {cellsize = (double) Math.abs(x[i]-x2);System.out.println("i: "+i+"; x2: "+x2 + "; xi: "+x[i]+"; New cellsize: "+cellsize);}
                if(Math.abs(x[i]-x3)<cellsize && Math.abs(x[i]-x3)!=0) 
                    {cellsize = (double) Math.abs(x[i]-x3);System.out.println("i: "+i+"; x3: "+x3 + "; xi: "+x[i]+"; New cellsize: "+cellsize);}
                if(Math.abs(y[i]-y1)<cellsize && Math.abs(y[i]-y1)!=0) 
                    {cellsize = (double) Math.abs(y[i]-y1);System.out.println("i: "+i+"; y1: "+y1 + "; yi: "+y[i]+"; New cellsize: "+cellsize);}
                if(Math.abs(y[i]-y2)<cellsize && Math.abs(y[i]-y2)!=0) 
                    {cellsize = (double) Math.abs(y[i]-y2);System.out.println("i: "+i+"; y2: "+y2 + "; yi: "+y[i]+"; New cellsize: "+cellsize);}
                if(Math.abs(y[i]-y3)<cellsize && Math.abs(y[i]-y3)!=0) 
                    {cellsize = (double) Math.abs(y[i]-y3);System.out.println("i: "+i+"; y3: "+y3 + "; yi: "+y[i]+"; New cellsize: "+cellsize);}
            }

        
        xDimWorld = worldRight-worldLeft;
        yDimWorld = worldTop-worldBottom;
        xCells = (int) Math.round(xDimWorld/cellsize)+1; //WAS ceil
        yCells = (int) Math.round(yDimWorld/cellsize)+1; //WAS ceil
        
    }
    
    public void reduceResolution(int reductionFactor)
    {
        xCells=(int) Math.ceil(xCells/reductionFactor)+1;
        yCells=(int) Math.ceil(yCells/reductionFactor)+1;
        cellsize=cellsize*reductionFactor;
        //create empty grid
        double[][] dataGrid=createNoDataGrid();
        //mark cells that have input data
        for(int i=0; i<worldX.length;i++)
        {
            Point2DInt gridpoint=getGridCoords(new Point2D(worldX[i],worldY[i]));
            dataGrid[gridpoint.x][gridpoint.y]=1;
        }
        //create new worldX and worldY arrays for each cell that contained old X and Y data
        ArrayList<Point2DDouble> newWorldCoords = new ArrayList<Point2DDouble>();
        for(int x=0; x<xCells;x++)
        {
            for(int y=0;y<yCells;y++)
            {
                if(dataGrid[x][y]!=GlobalResources.NODATAVALUE)
                {
                    Point2DDouble coords = new Point2DDouble(worldLeft+cellsize*x,worldTop-cellsize*y);
                    newWorldCoords.add(coords);
                }
            }
        }
        worldX=new double[newWorldCoords.size()];
        worldY=new double[newWorldCoords.size()];
        for(int i=0; i<newWorldCoords.size();i++)
        {
            worldX[i]=newWorldCoords.get(i).x;
            worldY[i]=newWorldCoords.get(i).y;
        }

    }
    
    public Point2D getWorldCoords(Point2DInt gridCoords)
    {
        double x = worldLeft+cellsize*gridCoords.x;
        double y = worldTop-cellsize * gridCoords.y;
        return new Point2D(x,y);
    }
    
    public double[][] createNoDataGrid()
    {
        double[][] noDataGrid=new double[xCells][yCells];
        for(int i=0;i<xCells;i++)
        {
            for(int j=0; j<yCells;j++)
                {noDataGrid[i][j]=GlobalResources.NODATAVALUE;}
        }
        return noDataGrid;
    }
    
    //returns a grid with 0s where it's not nodata
    public double[][] getEmptyGrid()
    {
        if(emptyGrid==null)
        {
           emptyGrid=createNoDataGrid();
           for(int i=0;i<worldX.length;i++)
               {
                    Point2DInt gridCoords=getGridCoords(new Point2D(worldX[i],worldY[i]));
                    emptyGrid[gridCoords.x][gridCoords.y]=0;
                }
            
        }
        
        return Helpers.deepArrayCopy(emptyGrid);
    }
    
    /**
     * 
     * @return Dimensions in grid cells
     */
    public Point2DInt getDimensions()
    {
        return new Point2DInt(xCells,yCells);
    }
    
    /**
     * 
     * @return Cell size.
     */
    public double getCellSize()
    {
        return cellsize;
    }
    
    /**
     * 
     * @param worldCoords A point in world coordinates.
     * @return The point in grid coordinates.
     */
    
    public Point2DInt getGridCoords(Point2D worldCoords)
    {
        int x = (int) (Math.round(worldCoords.x-worldLeft)/cellsize);
        int y = (int) (Math.round(worldTop-worldCoords.y)/cellsize);
        return new Point2DInt(x,y);
        
    }
    
    /**
     * 
     * @return Array containing 0 for cells not listed in the mapping grid file, and 1 for cells listed in the mapping grid file, i.e. the 1's are the part of the rectangular grid that is filled.
     */
    public double[][] isFilled()
    {
        
        double[][] result = new double[xCells+1][yCells+1];
        
        for(int i=0;i<worldX.length;i++)
        {   
            Point2DInt gridPoint = getGridCoords(new Point2D(worldX[i],worldY[i]));
            result[gridPoint.x][gridPoint.y]=1;
        }
        
        return result;
    }
    /**
     * Creates a data grid from lists of coordinates and data values.
     * @param worldX List of x coordinates in the world system, e.g. UTM.
     * @param worldY List of y coordinates in the world system, e.g. UTM.
     * @param value List of data values.
     * @return 
     */
    public DataGrid createDataGrid(double[] worldX, double[] worldY, double[] value)
    {
        double[][] result = createNoDataGrid();
        
        double max=-9999999;
        double min=9999999;
        for(int i=0;i<worldX.length;i++)
        {   
            Point2DInt gridPoint = getGridCoords(new Point2D(worldX[i],worldY[i]));
            result[gridPoint.x][gridPoint.y]=value[i];
            if(value[i]>max && value[i] != GlobalResources.NODATAVALUE) {max=value[i];}
            if(value[i]<min && value[i] != GlobalResources.NODATAVALUE) {min=value[i];}
        }
        
        return new DataGrid(result,max,min,GlobalResources.NODATAVALUE);
        
        
    }
    
    public CsvTableGeneral createTableFromLayer(SpatialDataLayer layer, boolean processed)
    {
        CsvTableGeneral table = new CsvTableGeneral();
        table.addColumn("x");
        table.addColumn("y");
        table.addColumn("value");
        
        //ArrayList<String> xList=new ArrayList<String>();
        //ArrayList<String> yList=new ArrayList<String>();
        //ArrayList<String> valueList=new ArrayList<String>();
        
        for(int i=0;i<worldX.length;i++)
        {
            ArrayList<String> row = new ArrayList<String>();
            row.add(worldX[i]+"");
            row.add(worldY[i]+"");
            Point2DInt gridCoords = getGridCoords(new Point2D(worldX[i],worldY[i]));
            if(processed) {row.add(layer.getProcessedGrid().getData()[gridCoords.x][gridCoords.y]+"");} //processed grid
            else {row.add(layer.getGrid().getData()[gridCoords.x][gridCoords.y]+"");}  //raw grid
            table.addRow(row);
        }
        
        return table;

    }
    
        public CsvTableGeneral createTableFromLayer(SpatialDataLayer layer, boolean processed, double cellSize)
        {
             CsvTableGeneral table = new CsvTableGeneral();
            table.addColumn(layer.getSource().xField);
            table.addColumn(layer.getSource().yField);
            table.addColumn(layer.getSource().valueField);
       
            
            //read out and write data at intervals given by new cellsize
            double[][] data; 
            if(processed) {data=layer.getProcessedGrid().getData();}
            else {data=layer.getGrid().getData();}
        
            double wx = worldLeft;          
            while(wx<worldRight)
            {
                double wy = worldTop;
                while(wy>worldBottom)
                {
                    Point2DInt gridCoords = getGridCoords(new Point2D(wx,wy));
                    double value = data[gridCoords.x][gridCoords.y];
                    if(value!=GlobalResources.NODATAVALUE)
                    {
                        ArrayList<String> row = new ArrayList<String>();
                        row.add(wx+"");
                        row.add(wy+"");
                        row.add(value+"");
                        table.addRow(row);
                    }
                    wy-=cellSize;
                }
                wx+=cellSize;
            }
            
        return table;

    }
    
    
}
