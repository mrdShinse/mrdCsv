/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mrdShinse.csv;

import mrdShinse.csv.CsvToken;

import java.io.Serializable;

/**
 * Created by shinse1128 on 2016/03/21.
 */
public class SimpleCsvToken implements Serializable, CsvToken {
    /**
     * デフォルトコンストラクタです。
     */
    protected SimpleCsvToken() {
    }

    public SimpleCsvToken(String value, int start, int end, boolean enclosed) {
    }

    /**
     * トークンの終了物理行番号を取得します。
     */
    public int getEndLineNumber() {
        return 0;
    }

    /**
     * トークンの開始物理行番号を取得します。
     */
    public int getStartLineNumber() {
        return 0;
    }

    /**
     * トークンの値を保持します、
     */
    public String getValue() {
        return "";
    }

    /**
     * トークンが囲み文字で囲まれていたかどうかを返します
     */
    public boolean isEnclosed() {
        return false;
    }
}