/*
 * Copyright 2009-2010 the original author or authors.
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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import mrdShinse.csv.handlers.StringArrayListHandler;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * {@link Csv} クラスの単体テストです。
 *
 * @author Koji Sugisawa
 */
public class CsvTest {

    private static final String path = "src/test/resources/";
    private static final String encoding = "Windows-31J";
    private static CsvConfig cfg;

    private static List<String[]> data;

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        cfg = new CsvConfig(',');
        cfg.setIgnoreTrailingWhitespaces(true);
        cfg.setIgnoreLeadingWhitespaces(true);
        cfg.setIgnoreEmptyLines(true);
        cfg.setSkipLines(1);
        cfg.setUtf8bomPolicy(true);

        final List<String[]> list = new ArrayList<String[]>(2);
        list.add(new String[]{"aaa", "b\nb\\\\b", "c\"cc"});
        list.add(new String[]{"zzz", "yyy", null});
        data = Collections.unmodifiableList(list);
    }

    @Test
    public void testLoadCsvReaderCsvHandlerOfT() throws IOException {
        final CsvReader reader = new CsvReader(new InputStreamReader(new FileInputStream(new File(path, "n225.csv")), encoding), cfg);
        try {
            final List<String[]> list = Csv.load(reader, new StringArrayListHandler());
            assertThat(list.size(), is(2694));
        } finally {
            Csv.closeQuietly(reader);
        }
    }

    @Test
    public void testLoadReaderCsvConfigCsvHandlerOfT() throws IOException {
        final Reader reader = new InputStreamReader(new FileInputStream(new File(path, "n225.csv")), encoding);
        try {
            final List<String[]> list = Csv.load(reader, cfg, new StringArrayListHandler());
            assertThat(list.size(), is(2694));
        } finally {
            Csv.closeQuietly(reader);
        }
    }

    @Test
    public void testLoadInputStreamStringCsvConfigCsvHandlerOfT() throws IOException {
        final InputStream in = new FileInputStream(new File(path, "n225.csv"));
        try {
            final List<String[]> list = Csv.load(in, encoding, cfg, new StringArrayListHandler());
            assertThat(list.size(), is(2694));
        } finally {
            Csv.closeQuietly(in);
        }
    }

    @Test
    public void testLoadInputStreamCsvConfigCsvHandlerOfT() throws IOException {
        final InputStream in = new FileInputStream(new File(path, "n225.csv"));
        try {
            final List<String[]> list = Csv.load(in, cfg, new StringArrayListHandler());
            assertThat(list.size(), is(2694));
        } finally {
            Csv.closeQuietly(in);
        }
    }

    @Test
    public void testLoadFileStringCsvConfigCsvHandlerOfT() throws IOException {
        final List<String[]> list = Csv.load(new File(path, "n225.csv"), encoding, cfg, new StringArrayListHandler());
        assertThat(list.size(), is(2694));
    }

    @Test
    public void testLoadFileCsvConfigCsvHandlerOfT() throws IOException {
        final List<String[]> list = Csv.load(new File(path, "n225.csv"), cfg, new StringArrayListHandler());
        assertThat(list.size(), is(2694));
    }

    @Test
    public void testLoadZipInputStreamStringCsvConfigCsvListHandlerOfT() throws IOException {
        final ZipInputStream zip = new ZipInputStream(new FileInputStream(new File(path, "n225.zip")));
        try {
            final List<String[]> list = Csv.load(zip, encoding, cfg, new StringArrayListHandler());
            assertThat(list.size(), is(2694));
        } finally {
            Csv.closeQuietly(zip);
        }
    }

    @Test
    public void testLoadZipInputStreamCsvConfigCsvListHandlerOfT() throws IOException {
        final ZipInputStream zip = new ZipInputStream(new FileInputStream(new File(path, "n225.zip")));
        try {
            final List<String[]> list = Csv.load(zip, cfg, new StringArrayListHandler());
            assertThat(list.size(), is(2694));
        } finally {
            Csv.closeQuietly(zip);
        }
    }

    @Test
    public void testLoadZipFileStringCsvConfigCsvListHandlerOfT() throws IOException {
        final ZipFile zip = new ZipFile(new File(path, "n225.zip"));
        try {
            final List<String[]> list = Csv.load(zip, encoding, cfg, new StringArrayListHandler());
            assertThat(list.size(), is(2694));
        } finally {
            zip.close();
        }
    }

    @Test
    public void testLoadZipFileCsvConfigCsvListHandlerOfT() throws IOException {
        final ZipFile zip = new ZipFile(new File(path, "n225.zip"));
        try {
            final List<String[]> list = Csv.load(zip, cfg, new StringArrayListHandler());
            assertThat(list.size(), is(2694));
        } finally {
            zip.close();
        }
    }

    @Test
    public void testSaveTCsvWriterCsvHandlerOfT() throws IOException {
        final File file = tempFolder.newFile("test.csv");
        final CsvWriter writer = new CsvWriter(new OutputStreamWriter(new FileOutputStream(file), encoding), cfg);
        try {
            Csv.save(data, writer, new StringArrayListHandler());
        } finally {
            Csv.closeQuietly(writer);
        }
        final List<String[]> list = Csv.load(file, cfg, new StringArrayListHandler());
        assertThat(list.size(), is(2));
    }

    @Test
    public void testSaveTWriterCsvConfigCsvHandlerOfT() throws IOException {
        final File file = tempFolder.newFile("test.csv");
        final Writer writer = new OutputStreamWriter(new FileOutputStream(file), encoding);
        try {
            Csv.save(data, writer, cfg, new StringArrayListHandler());
        } finally {
            Csv.closeQuietly(writer);
        }
        final List<String[]> list = Csv.load(file, cfg, new StringArrayListHandler());
        assertThat(list.size(), is(2));
    }

    @Test
    public void testSaveTOutputStreamStringCsvConfigCsvHandlerOfT() throws IOException {
        final File file = tempFolder.newFile("test.csv");
        final OutputStream out = new FileOutputStream(file);
        try {
            Csv.save(data, out, encoding, cfg, new StringArrayListHandler());
        } finally {
            Csv.closeQuietly(out);
        }
        final List<String[]> list = Csv.load(file, cfg, new StringArrayListHandler());
        assertThat(list.size(), is(2));
    }

    @Test
    public void testSaveTOutputStreamCsvConfigCsvHandlerOfT() throws IOException {
        final File file = tempFolder.newFile("test.csv");
        final OutputStream out = new FileOutputStream(file);
        try {
            Csv.save(data, out, cfg, new StringArrayListHandler());
        } finally {
            Csv.closeQuietly(out);
        }
        final List<String[]> list = Csv.load(file, cfg, new StringArrayListHandler());
        assertThat(list.size(), is(2));
    }

    @Test
    public void testSaveTFileStringCsvConfigCsvHandlerOfT() throws IOException {
        final File file = tempFolder.newFile("test.csv");
        Csv.save(data, file, encoding, cfg, new StringArrayListHandler());
        final List<String[]> list = Csv.load(file, cfg, new StringArrayListHandler());
        assertThat(list.size(), is(2));
    }

    @Test
    public void testSaveTFileCsvConfigCsvHandlerOfT() throws IOException {
        final File file = tempFolder.newFile("test.csv");
        Csv.save(data, file, cfg, new StringArrayListHandler());
        final List<String[]> list = Csv.load(file, cfg, new StringArrayListHandler());
        assertThat(list.size(), is(2));
    }

    @Test
    public void testSaveListOfTZipOutputStreamStringCsvConfigCsvListHandlerOfTString() throws IOException {
        final File file = tempFolder.newFile("test.zip");
        final ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(file));
        try {
            Csv.save(data, zip, encoding, cfg, new StringArrayListHandler(), "test.csv");
        } finally {
            Csv.closeQuietly(zip);
        }
        final ZipFile zipFile = new ZipFile(file);
        try {
            final List<String[]> list = Csv.load(zipFile, encoding, cfg, new StringArrayListHandler());
            assertThat(list.size(), is(2));
        } finally {
            zipFile.close();
        }
    }

    @Test
    public void testSaveListOfTZipOutputStreamCsvConfigCsvListHandlerOfTString() throws IOException {
        final File file = tempFolder.newFile("test.zip");
        final ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(file));
        try {
            Csv.save(data, zip, cfg, new StringArrayListHandler(), "test.csv");
        } finally {
            Csv.closeQuietly(zip);
        }
        final ZipFile zipFile = new ZipFile(file);
        try {
            final List<String[]> list = Csv.load(zipFile, cfg, new StringArrayListHandler());
            assertThat(list.size(), is(2));
        } finally {
            zipFile.close();
        }
    }
/*

    @Test
    public void testLoadZipFileCsvConfigCsvListHandlerOfTZipEntryFilter() throws IOException {
        final ZipFile zip = new ZipFile(new File(path, "n225.zip"));
        try {
            final List<String[]> list = Csv.load(zip, cfg, new StringArrayListHandler(), new RegexEntryNameFilter("^.+\\.csv$"));
            assertThat(list.size(), is(2694));
        } finally {
            zip.close();
        }
    }

    @Test
    public void testLoadZipFileStringCsvConfigCsvListHandlerOfTZipEntryFilter() throws IOException {
        final ZipFile zip = new ZipFile(new File(path, "sample.zip"));
        try {
            final List<Sample> list = Csv.load(zip, "utf-8", cfg,
                    new CsvEntityListHandler<Sample>(Sample.class)
                            .filter(new SimpleBeanFilter().in("label", "あ", "い", "う", "か", "き", "く"))
                            .order(BeanOrder.asc("no"))
                            .offset(1)
                            .limit(3),
                    new RegexEntryNameFilter("^.+\\.csv$")
            );
            assertThat(list.size(), is(3));
            assertThat(list.get(0).label, is("き"));
            assertThat(list.get(1).label, is("か"));
            assertThat(list.get(2).label, is("う"));
        } finally {
            zip.close();
        }
    }
    @Test
    public void testLoadZipInputStreamStringCsvConfigCsvListHandlerOfTZipEntryFilter() throws IOException {
        final ZipInputStream zip = new ZipInputStream(new FileInputStream(new File(path, "sample.zip")));
        try {
            final List<String[]> list =
                    Csv.load(zip, "utf-8", cfg,
                            new StringArrayListHandler()
                                    .filter(new SimpleCsvValueFilter().in(1, "あ", "い", "う", "か", "き", "く"))
                                    .offset(1)
                                    .limit(3),
                            new RegexEntryNameFilter("^.+\\.csv$")
                    );
            assertThat(list.size(), is(3));
            assertThat(list.get(0)[1], is("い"));
            assertThat(list.get(1)[1], is("う"));
            assertThat(list.get(2)[1], is("く"));
        } finally {
            Csv.closeQuietly(zip);
        }
    }

    @Test
    public void testLoadZipInputStreamCsvConfigCsvListHandlerOfTZipEntryFilter() throws IOException {
        final ZipInputStream zip = new ZipInputStream(new FileInputStream(new File(path, "n225.zip")));
        try {
            final List<String[]> list = Csv.load(zip, cfg, new StringArrayListHandler(), new RegexEntryNameFilter("^.+\\.csv$"));
            assertThat(list.size(), is(2694));
        } finally {
            Csv.closeQuietly(zip);
        }
    }
*/
}