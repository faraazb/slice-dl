package ui.common;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.UncheckedIOException;

/**
 * Inspired and Adapted from Cryptomator and they were
 * Inspired by de.jensd:fontawesomefx-fontawesome
 */
public class IconView extends Text {

    private static final Icon DEFAULT_GLYPH = Icon.ANCHOR;
    private static final double DEFAULT_GLYPH_SIZE = 12.0;
    private static final String FONT_PATH = "/css/font-awesome5-free-solid-900.otf";
    private static final Font FONT;

    private ObjectProperty<Icon> glyph = new SimpleObjectProperty<>(this, "glyph", DEFAULT_GLYPH);
    private DoubleProperty glyphSize = new SimpleDoubleProperty(this, "glyphSize", DEFAULT_GLYPH_SIZE);

    static {
        try {
            FONT = FontLoader.load(FONT_PATH);
        } catch (FontLoader.FontLoaderException e) {
            throw new UncheckedIOException(e);
        }
    }

    public IconView() {
        getStyleClass().addAll("glyph-icon");
        glyphProperty().addListener(this::glyphChanged);
        glyphSizeProperty().addListener(this::glyphSizeChanged);
        setFont(FONT);
        setGlyph(DEFAULT_GLYPH);
        setGlyphSize(DEFAULT_GLYPH_SIZE);
    }

    private void glyphChanged(@SuppressWarnings("unused") ObservableValue<? extends Icon> observable, @SuppressWarnings("unused") Icon oldValue, Icon newValue) {
        setText(newValue.unicode());
    }

    private void glyphSizeChanged(@SuppressWarnings("unused") ObservableValue<? extends Number> observable, @SuppressWarnings("unused") Number oldValue, Number newValue) {
        setFont(new Font(FONT.getFamily(), newValue.doubleValue()));
    }

    /* Getter/Setter */

    public ObjectProperty<Icon> glyphProperty() {
        return glyph;
    }

    public Icon getGlyph() {
        return glyph.get();
    }

    public void setGlyph(Icon glyph) {
        this.glyph.set(glyph == null ? DEFAULT_GLYPH : glyph);
    }

    public DoubleProperty glyphSizeProperty() {
        return glyphSize;
    }

    public double getGlyphSize() {
        return glyphSize.get();
    }

    public void setGlyphSize(double glyphSize) {
        this.glyphSize.set(glyphSize);
    }
}