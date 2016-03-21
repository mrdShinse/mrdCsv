package mrdShinse.csv;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Created by shinse1128 on 2016/03/21.
 */
public class CsvConfig implements Serializable, Cloneable {

    /**
     * デフォルトのエスケープ文字 (\) です。
     */
    public static final char DEFAULT_ESCAPE = '\\';
    /**
     * デフォルトの囲み文字 (") です。
     */
    public static final char DEFAULT_QUOTE = '"';
    /**
     * デフォルトの囲み文字出力方法の種類 (QuotePolicy.ALL) です。
     */
    public static final QuotePolicy DEFAULT_QUOTE_POLICY = QuotePolicy.ALL;
    /**
     * デフォルトの区切り文字 (,) です。
     */
    public static final char DEFAULT_SEPARATOR = ',';
    /**
     * デフォルトの先頭から読飛ばす論理行数 (0) です。
     */
    public static final int DEFAULT_SKIP_LINES = 0;

    private char escape;
    private char quote;
    private QuotePolicy quotePolicy;
    private char separator;
    private int skipLines;
    private boolean quoteDisabled;
    private boolean escapeDisabled;
    private String breakString;
    private Pattern[] ignoreLinePatterns;
    private String lineSeparator;
    private String nullString;
    private boolean ignoreCaseNullString;
    private boolean ignoreEmptyLines;
    private boolean ignoreLeadingWhitespaces;
    private boolean ignoreTrailWhitespaces;
    private boolean utf8bomPolicy;
    private boolean variableColumns;


    /**
     * Default Constructor
     */
    public CsvConfig() {
        this(DEFAULT_SEPARATOR, DEFAULT_QUOTE, DEFAULT_ESCAPE, true, true);
    }

    /**
     * Constructor
     *
     * @param separator
     */
    public CsvConfig(char separator) {
        this(separator, DEFAULT_QUOTE, DEFAULT_ESCAPE, true, true);
    }

    /**
     * Constructor
     *
     * @param separator
     * @param quote
     * @param escape
     */
    public CsvConfig(char separator, char quote, char escape) {
        this(separator, quote, escape, true, true);
    }

    /**
     * Constructor
     *
     * @param separator
     * @param quote
     * @param escape
     * @param quoteDisabled
     * @param escapeDisabled
     */
    public CsvConfig(char separator, char quote, char escape, boolean quoteDisabled, boolean escapeDisabled) {
        this.separator = separator;
        this.quote = quote;
        this.escape = escape;
        this.quoteDisabled = quoteDisabled;
        this.escapeDisabled = escapeDisabled;

        this.quotePolicy = this.DEFAULT_QUOTE_POLICY;
        this.skipLines = this.DEFAULT_SKIP_LINES;
        this.lineSeparator = System.getProperty("line.separator");
        this.variableColumns = true;
    }

    public CsvConfig clone() {
        return new CsvConfig(separator, quote, escape);
    }

    /**
     * 値の改行文字列を置換える文字列を返します。
     */
    public String getBreakString() {
        return breakString;
    }

    /**
     * エスケープ文字を返します。
     */
    public char getEscape() {
        return this.escape;
    }

    /**
     * 無視する行の正規表現パターン群を返します。
     */
    public Pattern[] getIgnoreLinePatterns() {
        return ignoreLinePatterns;
    }

    /**
     * データ出力時の改行文字列を返します。
     */
    public String getLineSeparator() {
        return lineSeparator;
    }

    /**
     * 値がないことを表す文字列を返します。
     */
    public String getNullString() {
        return nullString;
    }

    /**
     * 囲み文字を返します。
     */
    public char getQuote() {
        return quote;
    }

    /**
     * 囲み文字出力方法の種類を返します。
     */
    public QuotePolicy getQuotePolicy() {
        return quotePolicy;
    }

    /**
     * 区切り文字を返します。
     */
    public char getSeparator() {
        return separator;
    }

    /**
     * ファイルの先頭から読飛ばす行数を返します。
     */
    public int getSkipLines() {
        return skipLines;
    }

    /**
     * エスケープ文字を無効にするかどうかを返します。
     */
    public boolean isEscapeDisabled() {
        return escapeDisabled;
    }

    /**
     * 値がないことを表す文字列の大文字と小文字を区別するかどうかを返します。
     */
    public boolean isIgnoreCaseNullString() {
        return ignoreCaseNullString;
    }

    /**
     * 空行を無視するかどうかを返します。
     */
    public boolean isIgnoreEmptyLines() {
        return ignoreEmptyLines;
    }

    /**
     * 値より前のホワイトスペースを除去するかどうかを返します。
     */
    public boolean isIgnoreLeadingWhitespaces() {
        return ignoreLeadingWhitespaces;
    }

    /**
     * 値より後ろのホワイトスペースを除去するかどうかを返します。
     */
    public boolean isIgnoreTrailingWhitespaces() {
        return ignoreTrailWhitespaces;
    }

    /**
     * 囲み文字を無効にするかどうかを返します。
     */
    public boolean isQuoteDisabled() {
        return quoteDisabled;
    }

    /**
     * UTF-8 エンコーディングでの出力時に BOM (Byte Order Mark) を付与するかどうかを返します。
     */
    public boolean isUtf8bomPolicy() {
        return utf8bomPolicy;
    }

    /**
     * 可変項目数を許可するかどうかを返します。
     */
    public boolean isVariableColumns() {
        return variableColumns;
    }

    /**
     * 値の改行文字列を置換える文字列を設定します。
     */
    public void setBreakString(String breakString) {
        this.breakString = breakString;
    }

    /**
     * エスケープ文字を設定します。
     */
    public void setEscape(char escape) {
        this.escape = escape;
    }

    /**
     * エスケープ文字を無効にするかどうかを設定します。
     */
    public void setEscapeDisabled(boolean disabled) {
        this.escapeDisabled = disabled;
    }

    /**
     * 値がないことを表す文字列の大文字と小文字を区別するかどうかを設定します。
     */
    public void setIgnoreCaseNullString(boolean ignoreCaseNullString) {
        this.ignoreCaseNullString = ignoreCaseNullString;
    }

    /**
     * 空行を無視するかどうかを設定します。
     */
    public void setIgnoreEmptyLines(boolean ignore) {
        this.ignoreEmptyLines = ignore;
    }

    /**
     * 値より前のホワイトスペースを除去するかどうかを設定します。
     */
    public void setIgnoreLeadingWhitespaces(boolean ignore) {
        this.ignoreLeadingWhitespaces = ignore;
    }

    /**
     * 無視する行の正規表現パターン群を設定します。
     */
    public void setIgnoreLinePatterns(Pattern... ignoreLinePatterns) {
        this.ignoreLinePatterns = ignoreLinePatterns;
    }

    /**
     * 値より後ろのホワイトスペースを除去するかどうかを設定します。
     */
    public void setIgnoreTrailingWhitespaces(boolean ignore) {
        this.ignoreTrailWhitespaces = ignore;
    }

    /**
     * データ出力時の改行文字列を設定します。
     */
    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }

    /**
     * 値がないことを表す文字列を設定します。
     */
    public void setNullString(String nullString) {
        this.nullString = nullString;
    }

    /**
     * 値がないことを表す文字列を設定します。
     */
    public void setNullString(String nullString, boolean ignoreCase) {
        this.ignoreCaseNullString = ignoreCase;
        this.nullString = nullString;
    }

    /**
     * 囲み文字を設定します。
     */
    public void setQuote(char quote) {
        this.quote = quote;
    }

    /**
     * 囲み文字を無効にするかどうかを設定します。
     */
    public void setQuoteDisabled(boolean disabled) {
        this.quoteDisabled = disabled;
    }

    /**
     * 囲み文字出力方法の種類を設定します。
     */
    public void setQuotePolicy(QuotePolicy quotePolicy) {
        if (quotePolicy == null) {
            throw new IllegalArgumentException("QuotePolicy must not be null");
        }
        this.quotePolicy = quotePolicy;
    }

    /**
     * 区切り文字を設定します。
     */
    public void setSeparator(char separator) {
        this.separator = separator;
    }

    /**
     * ファイルの先頭から読飛ばす行数を設定します。
     */
    public void setSkipLines(int skipLines) {
        this.skipLines = skipLines;
    }

    /**
     * UTF-8 エンコーディングでの出力時に BOM (Byte Order Mark) を付与するかどうかを設定します。
     */
    public void setUtf8bomPolicy(boolean utf8bomPolicy) {
        this.utf8bomPolicy = utf8bomPolicy;
    }

    /**
     * 可変項目数を許可するかどうかを設定します。
     */
    public void setVariableColumns(boolean variableColumns) {
        this.variableColumns = variableColumns;
    }

    /**
     * 区切り文字および囲み文字、エスケープ文字の組合せを検証します
     */
    public void validate() {
        if (separator == '\r'
                || separator == '\n') {
            throw new IllegalArgumentException("Invalid separator character");
        }
        if (separator == ','
                && (quote == ',' || quote == '\r' || quote == '\n')
                && escape == '"') {
            throw new IllegalArgumentException("Invalid quote character");
        }
        if (separator == ','
                && quote == '"'
                && (escape == ',' || escape == '\r' || escape == '\n')) {
            throw new IllegalArgumentException("Invalid escape character");
        }
    }
}
