package mrdShinse.csv;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shinse1128 on 2016/03/21.
 */
public class CsvReader implements Closeable {
    /**
     * デフォルトのバッファーサイズとデフォルトの区切り文字形式情報を使用して、このクラスを構築するコンストラクタです。
     */
    public CsvReader(Reader in) {
    }

    /**
     * デフォルトのバッファーサイズと指定された区切り文字形式情報を使用して、このクラスを構築するコンストラクタです。
     */
    public CsvReader(Reader in, CsvConfig cfg) {
    }

    /**
     * 指定されたバッファーサイズとデフォルトの区切り文字形式情報を使用して、このクラスを構築するコンストラクタです。
     */
    public CsvReader(Reader in, int sz) {
    }

    /**
     * 指定されたバッファーサイズと指定された区切り文字形式情報を使用して、このクラスを構築するコンストラクタです
     */
    public CsvReader(Reader in, int sz, CsvConfig cfg) {
    }

    @Override
    public void close() {
    }

    /**
     * 終了物理行番号の現在値を取得します。
     */
    public int getEndLineNumber() {
        return 0;
    }

    /**
     * 論理行番号の現在値を取得します。
     */
    public int getLineNumber() {
        return 0;
    }

    /**
     * 開始物理行番号の現在値を取得します。
     */
    public int getStartLineNumber() {
        return 0;
    }

    /**
     * ファイルの終わりに達したかどうかを取得します。
     */
    public boolean isEndOfFile() {
        return false;
    }

    /**
     * 論理行を読込み区切り文字形式データトークンをリストして返します。
     */
    public List<CsvToken> readTokens() throws CsvTokenException {
        return new ArrayList<>();
    }

    /**
     * 論理行を読込み区切り文字形式データトークンの値をリストして返します
     */
    public List<String> readValues() throws CsvTokenException {
        return new ArrayList<>();
    }
}
