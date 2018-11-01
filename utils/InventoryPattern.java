package utils;

public class InventoryPattern {

    private static final byte ROWS = 7;
    private static final byte COLUMNS = 4;
    private static final byte SLOTS = ROWS * COLUMNS;

    public static int[] buildRegularPattern() {
        int[] array = new int[SLOTS];
        for (int index = 0; index < array.length; index++) {
            array[index] = index;
        }
        return array;
    }

    public static int[] buildSnakePattern() {
        int[] array = new int[SLOTS];
        byte index = 0;
        byte value = - COLUMNS - 1;
        byte row = 0;
        while (row < ROWS) {
            if (row % 2 == 0) {
                value += COLUMNS + 1;
                for (int iterator = 0; iterator < COLUMNS; iterator++) {
                    array[index++] = value++;
                }
            }
            else {
                value += COLUMNS - 1;
                for (int iterator = 0; iterator < COLUMNS; iterator++) {
                    array[index++] = value--;
                }
            }
            row++;
        }
        return array;
    }

    public enum CLICK_PATTERN {
        REGULAR("Regular", buildRegularPattern()),
        SNAKE("Snake", buildSnakePattern());

        private String name;
        private int[] pattern;

        CLICK_PATTERN(String name, int[] pattern) {
            this.name = name;
            this.pattern = pattern;
        }
        public String getName() {
            return this.name;
        }

        public int[] getPattern() {
            return this.pattern;
        }

        public static CLICK_PATTERN getByName(String name){
            for(CLICK_PATTERN e : CLICK_PATTERN.values()){
                if(name == e.getName()) return e;
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
