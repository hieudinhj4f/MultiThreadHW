import java.util.HashMap;
import java.util.Map;

// Giao diện Flyweight
interface Glyph {
    void draw(String position);
}

// Đối tượng Flyweight được chia sẻ
class CharacterGlyph implements Glyph {
    private final char symbol; // Intrinsic state (chung)

    public CharacterGlyph(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void draw(String position) {
        // Extrinsic state (không chia sẻ): position
        System.out.println("Draw '" + symbol + "' at " + position);
    }
}

// Factory quản lý Flyweight
class GlyphFactory {
    private final Map<Character, Glyph> pool = new HashMap<>();

    public Glyph getGlyph(char symbol) {
        // Nếu chưa có thì tạo mới và lưu vào pool
        if (!pool.containsKey(symbol)) {
            pool.put(symbol, new CharacterGlyph(symbol));
        }
        return pool.get(symbol);
    }

    public int totalGlyphsCreated() {
        return pool.size();
    }
}

// Client sử dụng
public class FlyweightDemo {
    public static void main(String[] args) {
        GlyphFactory factory = new GlyphFactory();

        // Chuỗi văn bản giả định
        String text = "AABBCAB";

        // Vị trí hiển thị mỗi ký tự (extrinsic state)
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Glyph glyph = factory.getGlyph(c);
            glyph.draw("position " + i);
        }

        System.out.println("Total Glyphs created: " + factory.totalGlyphsCreated());
    }
}
