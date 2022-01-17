class Level {
    private static int width;
    private static int height;
    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
class LevelTooBigException extends Exception {

    public LevelTooBigException(String message) {

        super(message);
    }
    public LevelTooBigException() {
    }
}
class LevelLoader {
    public void load(Level level) throws LevelTooBigException {
 //   System.out.println("Level loaded");
        if (level.getHeight()* level.getWidth() <= 100000) {
            System.out.println("Level loaded");
        } else {
            //   System.out.println("Level too big");
           throw new LevelTooBigException("Level too big");
        }
    }
}
class LevelLoaderTest {
    public static void main(String[] args) {
        //Level loaded
        try {
            new LevelLoader().load(new Level(10, 20));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }
        //Level too big
        try {
            new LevelLoader().load(new Level(10000, 2000));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }
    }
}
