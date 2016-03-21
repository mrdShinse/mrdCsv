package mrdShinse.csv.handlers;

import mrdShinse.csv.CsvReader;
import mrdShinse.csv.CsvWriter;

import java.io.IOException;
import java.util.List;

/**
 * Created by shinse1128 on 2016/03/21.
 */
public class StringArrayListHandler extends AbstractCsvListHandler<String[], StringArrayListHandler> {

    /**
     * 区切り文字形式入力ストリームを読込んで区切り文字形式データのリストを返します。
     *
     * @param reader       区切り文字形式入力ストリーム
     * @param ignoreScalar スカラー副問い合わせを行うかどうか
     * @return 区切り文字形式データのリスト
     * @throws IOException              入出力例外が発生した場合
     * @throws IllegalArgumentException パラメータが不正な場合
     * @see #processScalar(List)
     * @since 1.3.0
     */
    @Override
    public List<String[]> load(CsvReader reader, boolean ignoreScalar) throws IOException {
        return null;
    }

    /**
     * 指定された区切り文字形式データのリストを区切り文字形式出力ストリームへ書込みます。
     *
     * @param list   区切り文字形式データのリスト
     * @param writer 区切り文字形式出力ストリーム
     * @throws IOException              入出力例外が発生した場合
     * @throws IllegalArgumentException パラメータが不正な場合
     */
    @Override
    public void save(List<String[]> list, CsvWriter writer) throws IOException {

    }

}
