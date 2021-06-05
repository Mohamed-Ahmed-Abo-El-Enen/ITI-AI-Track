import java.io.Serializable;

/**
 * Labeled instance type, Spark SQL can infer schema from Java Beans.
 */
@SuppressWarnings("serial")
public class JavaLabeledDocument extends JavaDocument implements Serializable {

    private long label;

    public JavaLabeledDocument(long id, String text, long label) {
        super(id, text);
        this.label = label;
    }

    public double getLabel() {
        return this.label;
    }
}