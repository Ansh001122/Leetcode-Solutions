class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = clamp(xCenter, x1, x2);
        int closestY = clamp(yCenter, y1, y2);
        
        long distX = xCenter - closestX;
        long distY = yCenter - closestY;
        long distanceSquared = distX * distX + distY * distY;
        
        return distanceSquared <= (long) radius * radius;
    }
    private int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }
}