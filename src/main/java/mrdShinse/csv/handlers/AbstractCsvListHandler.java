package mrdShinse.csv.handlers;

import mrdShinse.csv.CsvListHandler;
import mrdShinse.csv.CsvReader;

import java.io.IOException;
import java.util.List;

/**
 * Created by shinse1128 on 2016/03/21.
 */
public abstract class AbstractCsvListHandler <T, H extends AbstractCsvListHandler<T, H>> implements CsvListHandler<T> {

    /**
     * 取得データの開始位置を保持します。
     */
    protected int offset;

    /**
     * 取得データの限度数を保持します。
     */
    protected int limit;

    /**
     * デフォルトコンストラクタです。
     */
    public AbstractCsvListHandler() {}

    @Override
    public void setOffset(final int offset) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public H offset(final int offset) {
        return null;
    }

    @Override
    public void setLimit(final int limit) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public H limit(final int limit) {
        return null;
    }

    @Override
    public List<T> load(final CsvReader reader) throws IOException {
        return null;
    }

    /**
     * {@inheritDoc}
     * この実装は単に {@code offset} と {@code limit} を使用して処理します。
     */
    @Override
    public List<T> processScalar(final List<T> list) {
        return null;
    }
}
