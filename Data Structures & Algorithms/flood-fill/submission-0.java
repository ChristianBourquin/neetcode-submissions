class Solution {
    int origColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        origColor = image[sr][sc];
        traverse(image, sr, sc, color);
        return image;
    }

    public void traverse(int[][] image, int r, int c, int color){
        //check if tile is not valid
        if(Math.min(r, c) < 0 || r == image.length ||  c == image[0].length || image[r][c] != origColor ){
            return;
        }

        image[r][c] = color;

        traverse(image, r + 1, c, color);
        traverse(image, r - 1, c, color);
        traverse(image, r, c + 1, color);
        traverse(image, r, c - 1, color);

        return;
    }
}