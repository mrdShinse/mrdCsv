package mrdShinse.csv;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by shinse1128 on 2016/03/21.
 */
public class CsvWriter implements Closeable, Flushable {
    /**
     * デフォルトのバッファーサイズとデフォルトの区切り文字形式情報を使用して、このクラスを構築するコンストラクタです。
     */
    public CsvWriter(Writer out) {
    }

    /**
     * デフォルトのバッファーサイズと指定された区切り文字形式情報を使用して、このクラスを構築するコンストラクタです。
     */
    public CsvWriter(Writer out, CsvConfig cfg) {
    }

    /**
     * 指定されたバッファーサイズとデフォルトの区切り文字形式情報を使用して、このクラスを構築するコンストラクタです。
     */
    public CsvWriter(Writer out, int sz) {
    }

    /**
     * 指定されたバッファーサイズと指定された区切り文字形式情報を使用して、このクラスを構築するコンストラクタです
     */
    public CsvWriter(Writer out, int sz, CsvConfig cfg) {
    }

    public void close() {
    }

    public void flush() {
    }

    /**
     * 指定された CSV トークンのリストを書き込みます。
     */
    public void writeTokens(List<CsvToken> tokens) {
    }

    /**
     * 指定された CSV トークンの値リストを書き込みます
     */
    public void writeValues(List<String> values) throws CsvValueException {
    }
}
