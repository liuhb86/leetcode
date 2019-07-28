object Solution {
    def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
        if (image(sr)(sc) != newColor) {
            flood(image, sr, sc, image(sr)(sc), newColor)
        }
        image
    }
    
    def flood(image: Array[Array[Int]], r: Int, c: Int, color: Int, newColor: Int) {
        if (r<0 || r>= image.length) return
        if (c<0 || c>= image(r).length) return
        if (image(r)(c) != color) return
        image(r)(c) = newColor
        flood(image, r-1, c, color, newColor)
        flood(image, r+1, c, color, newColor)
        flood(image, r, c-1, color, newColor)
        flood(image, r, c+1, color, newColor)
    }
}