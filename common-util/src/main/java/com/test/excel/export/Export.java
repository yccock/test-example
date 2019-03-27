package com.test.excel.export;


import com.test.excel.handler.DataHandler;

import java.io.IOException;

public interface Export<T extends DataHandler> {

    public Export writeData(DataHandler dataHandler);

    public Export writeFile(String filename) throws IOException;

    // public Export writeResponse(HttpServletResponse response, String fileName) throws IOException;

    public void dispose();
}
