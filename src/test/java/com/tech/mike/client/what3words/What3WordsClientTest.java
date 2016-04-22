package com.tech.mike.client.what3words;

import com.tech.mike.client.ClientHttpHelper;
import com.tech.mike.client.DtoMapper;
import com.tech.mike.config.What3WordsConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.mockito.Mockito.*;

public class What3WordsClientTest {

    What3WordsClient what3WordsClient;

    private ClientHttpHelper mockedHttpHelper;

    @Before
    public void setup() {
        mockedHttpHelper = mock(ClientHttpHelper.class);
        what3WordsClient = new What3WordsClient(new What3WordsConfiguration(), mockedHttpHelper, new DtoMapper());
    }

    @Test
    public void doTheThing() {
        // Given
        when(mockedHttpHelper.getResponseContentAsStream(any())).thenReturn(mock(InputStream.class));

        // When

        // Then

        what3WordsClient.getPositionFromWords("foo.bar.baz");
    }
}
