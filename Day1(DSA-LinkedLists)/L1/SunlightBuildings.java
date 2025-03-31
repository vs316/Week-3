package DSA.LinkedLists;

public class SunlightBuildings {
    public static int countBuildings(int[] heights, String direction){
        if(heights==null|| heights.length==0||direction==null){
            return 0;
        }
        direction=direction.toLowerCase();

        switch(direction){
            case "north":
                return heights.length;
            case "south":
                return 0;
            case "west": {
                int count=0;
                int maxHeight=0;
                for(int height:heights){
                    if(height>maxHeight){
                        count++;
                        maxHeight=height;
                    }
                }
                return count;
            }
            case "east":{
                int count=0;
                int maxHeight=0;
                for (int i = heights.length-1; i >=0 ; i--) {
                    if(heights[i]>maxHeight){
                        count++;
                        maxHeight=heights[i];
                    }
                }
                return count;
            }
            default:
                System.out.println("Invalid direction");
                return 0;
        }
    }

    public static void main(String[] args) {
        int[] bh= {3,7,8,3,6,1};
        System.out.println(countBuildings(bh,"north"));
        System.out.println(countBuildings(bh,"south"));
        System.out.println(countBuildings(bh,"east"));
        System.out.println(countBuildings(bh,"west"));
    }
}
