package mrdShinse.csv;

import java.io.*;
import java.util.List;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by shinse1128 on 2016/03/21.
 */
public abstract class Csv {
    /**
     * デフォルトコンストラクタです。
     */
    protected Csv() {
    }

    /**
     * 無条件に、Closeable を閉じます。
     */
    protected static void closeQuietly(Closeable closeable) {

    }

    /**
     * 指定された区切り文字形式入力ストリームを読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> T load(CsvReader reader, CsvHandler<T> handler) {
        return null;
    }

    /**
     * 指定されたファイルをプラットフォームのデフォルトエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> T load(File file, CsvConfig cfg, CsvHandler<T> handler) {
        return null;
    }

    /**
     * 指定されたファイルを指定されたエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> T load(File file, String encoding, CsvConfig cfg, CsvHandler<T> handler) {
        return null;
    }

    /**
     * 指定された入力ストリームをプラットフォームのデフォルトエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> T load(InputStream in, CsvConfig cfg, CsvHandler<T> handler) {
        return null;
    }

    /**
     * 指定された入力ストリームを指定されたエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> T load(InputStream in, String encoding, CsvConfig cfg, CsvHandler<T> handler) {
        return null;
    }

    /**
     * 指定された文字入力ストリームを読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> T load(Reader reader, CsvConfig cfg, CsvHandler<T> handler) {
        return null;
    }

    /**
     * 指定された ZIP ファイルからすべての ZIP エントリをプラットフォームのデフォルトエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> List<T> load(ZipFile zipFile, CsvConfig cfg, CsvListHandler<T> handler) {
        return null;
    }

    /**
     * 指定された ZIP ファイルから指定されたフィルタの基準を満たす ZIP エントリをプラットフォームのデフォルトエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> List<T> load(ZipFile zipFile, CsvConfig cfg, CsvListHandler<T> handler, ZipEntryFilter filter) {
        return null;
    }

    /**
     * 指定された ZIP ファイルからすべての ZIP エントリを指定されたエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> List<T> load(ZipFile zipFile, String encoding, CsvConfig cfg, CsvListHandler<T> handler) {
        return null;
    }

    /**
     * 指定された ZIP ファイルから指定されたフィルタの基準を満たす ZIP エントリを指定されたエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> List<T> load(ZipFile zipFile, String encoding, CsvConfig cfg, CsvListHandler<T> handler, ZipEntryFilter filter) {
        return null;
    }

    /**
     * 指定された ZIP 入力ストリームからすべての ZIP エントリをプラットフォームのデフォルトエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> List<T> load(ZipInputStream in, CsvConfig cfg, CsvListHandler<T> handler) {
        return null;
    }

    /**
     * 指定された ZIP 入力ストリームから指定されたフィルタの基準を満たす ZIP エントリをプラットフォームのデフォルトエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> List<T> load(ZipInputStream in, CsvConfig cfg, CsvListHandler<T> handler, ZipEntryFilter filter) {
        return null;
    }

    /**
     * 指定された ZIP 入力ストリームからすべての ZIP エントリを指定されたエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> List<T> load(ZipInputStream in, String encoding, CsvConfig cfg, CsvListHandler<T> handler) {
        return null;
    }

    /**
     * 指定された ZIP 入力ストリームから指定されたフィルタの基準を満たす ZIP エントリを指定されたエンコーディングで読込み、 ハンドラによって変換された区切り文字形式データのインスタンスを返します。
     */
    public static <T> List<T> load(ZipInputStream in, String encoding, CsvConfig cfg, CsvListHandler<T> handler, ZipEntryFilter filter) {
        return null;
    }

    /**
     * 指定された区切り文字形式データのインスタンスを ハンドラによって変換して指定された ZIP 出力ストリームへプラットフォームのデフォルトエンコーディングで指定された ZIP エントリを書込みます。
     */
    public static <T> void save(List<T> obj, ZipOutputStream out, CsvConfig cfg, CsvListHandler<T> handler, String entryName) {
    }

    /**
     * 指定された区切り文字形式データのインスタンスを ハンドラによって変換して指定された ZIP 出力ストリームへ指定されたエンコーディングで指定された ZIP エントリを書込みます。
     */
    public static <T> void save(List<T> obj, ZipOutputStream out, String encoding, CsvConfig cfg, CsvListHandler<T> handler, String entryName) {
    }

    /**
     * 指定された区切り文字形式データのインスタンスを ハンドラによって変換して指定された区切り文字形式出力ストリームへ書込みます。
     */
    public static <T> void save(T obj, CsvWriter writer, CsvHandler<T> handler) {
    }

    /**
     * 指定された区切り文字形式データのインスタンスを ハンドラによって変換して指定されたファイルへプラットフォームのデフォルトエンコーディングで書込みます。
     */
    public static <T> void save(T obj, File file, CsvConfig cfg, CsvHandler<T> handler) {
    }

    /**
     * 指定された区切り文字形式データのインスタンスを ハンドラによって変換して指定されたファイルへ指定されたエンコーディングで書込みます。
     */
    public static <T> void save(T obj, File file, String encoding, CsvConfig cfg, CsvHandler<T> handler) {
    }

    /**
     * 指定された区切り文字形式データのインスタンスを ハンドラによって変換して指定された出力ストリームへプラットフォームのデフォルトエンコーディングで書込みます。
     */
    public static <T> void save(T obj, OutputStream out, CsvConfig cfg, CsvHandler<T> handler) {
    }

    /**
     * 指定された区切り文字形式データのインスタンスを ハンドラによって変換して指定された出力ストリームへ指定されたエンコーディングで書込みます。
     */
    public static <T> void save(T obj, OutputStream out, String encoding, CsvConfig cfg, CsvHandler<T> handler) {
    }

    /**
     * 指定された区切り文字形式データのインスタンスを ハンドラによって変換して指定された文字出力ストリームへ書込みます。
     */
    public static <T> void save(T obj, Writer writer, CsvConfig cfg, CsvHandler<T> handler) {
    }
}
