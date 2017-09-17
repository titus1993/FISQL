function ejecutarUSQL(){
    $.post("/fisql/ejecutarUsql",
    {
        usqlCode: editor.getValue()
    })
        .done(function(json_respuesta, status){
            $('#output-datos').val($('#output-datos').val()+json_respuesta['salida']);
            var respuesta = json_respuesta['salida'];
            respuesta = String(repuesta);
            editormensajes.setValue(respuesta);
        });

}


function agregarReporte() {
    document.getElementById('seccionContenido').innerHTML += "<div class=\"box-body\">\n" +
        "                                    <table id=\"resultado\" class=\"table table-bordered table-striped\">\n" +
        "                                        <thead>\n" +
        "                                        <tr>\n" +
        "                                            <th>Rendering engine</th>\n" +
        "                                            <th>Browser</th>\n" +
        "                                            <th>Platform(s)</th>\n" +
        "                                            <th>Engine version</th>\n" +
        "                                            <th>CSS grade</th>\n" +
        "                                        </tr>\n" +
        "                                        </thead>\n" +
        "                                        <tbody>\n" +
        "                                        <tr>\n" +
        "                                            <td>Trident</td>\n" +
        "                                            <td>Internet\n" +
        "                                                Explorer 4.0\n" +
        "                                            </td>\n" +
        "                                            <td>Win 95+</td>\n" +
        "                                            <td> 4</td>\n" +
        "                                            <td>X</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Trident</td>\n" +
        "                                            <td>Internet\n" +
        "                                                Explorer 5.0\n" +
        "                                            </td>\n" +
        "                                            <td>Win 95+</td>\n" +
        "                                            <td>5</td>\n" +
        "                                            <td>C</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Trident</td>\n" +
        "                                            <td>Internet\n" +
        "                                                Explorer 5.5\n" +
        "                                            </td>\n" +
        "                                            <td>Win 95+</td>\n" +
        "                                            <td>5.5</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Trident</td>\n" +
        "                                            <td>Internet\n" +
        "                                                Explorer 6\n" +
        "                                            </td>\n" +
        "                                            <td>Win 98+</td>\n" +
        "                                            <td>6</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Trident</td>\n" +
        "                                            <td>Internet Explorer 7</td>\n" +
        "                                            <td>Win XP SP2+</td>\n" +
        "                                            <td>7</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Trident</td>\n" +
        "                                            <td>AOL browser (AOL desktop)</td>\n" +
        "                                            <td>Win XP</td>\n" +
        "                                            <td>6</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Firefox 1.0</td>\n" +
        "                                            <td>Win 98+ / OSX.2+</td>\n" +
        "                                            <td>1.7</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Firefox 1.5</td>\n" +
        "                                            <td>Win 98+ / OSX.2+</td>\n" +
        "                                            <td>1.8</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Firefox 2.0</td>\n" +
        "                                            <td>Win 98+ / OSX.2+</td>\n" +
        "                                            <td>1.8</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Firefox 3.0</td>\n" +
        "                                            <td>Win 2k+ / OSX.3+</td>\n" +
        "                                            <td>1.9</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Camino 1.0</td>\n" +
        "                                            <td>OSX.2+</td>\n" +
        "                                            <td>1.8</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Camino 1.5</td>\n" +
        "                                            <td>OSX.3+</td>\n" +
        "                                            <td>1.8</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Netscape 7.2</td>\n" +
        "                                            <td>Win 95+ / Mac OS 8.6-9.2</td>\n" +
        "                                            <td>1.7</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Netscape Browser 8</td>\n" +
        "                                            <td>Win 98SE+</td>\n" +
        "                                            <td>1.7</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Netscape Navigator 9</td>\n" +
        "                                            <td>Win 98+ / OSX.2+</td>\n" +
        "                                            <td>1.8</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Mozilla 1.0</td>\n" +
        "                                            <td>Win 95+ / OSX.1+</td>\n" +
        "                                            <td>1</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Mozilla 1.1</td>\n" +
        "                                            <td>Win 95+ / OSX.1+</td>\n" +
        "                                            <td>1.1</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Mozilla 1.2</td>\n" +
        "                                            <td>Win 95+ / OSX.1+</td>\n" +
        "                                            <td>1.2</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Mozilla 1.3</td>\n" +
        "                                            <td>Win 95+ / OSX.1+</td>\n" +
        "                                            <td>1.3</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Mozilla 1.4</td>\n" +
        "                                            <td>Win 95+ / OSX.1+</td>\n" +
        "                                            <td>1.4</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Mozilla 1.5</td>\n" +
        "                                            <td>Win 95+ / OSX.1+</td>\n" +
        "                                            <td>1.5</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Mozilla 1.6</td>\n" +
        "                                            <td>Win 95+ / OSX.1+</td>\n" +
        "                                            <td>1.6</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Mozilla 1.7</td>\n" +
        "                                            <td>Win 98+ / OSX.1+</td>\n" +
        "                                            <td>1.7</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Mozilla 1.8</td>\n" +
        "                                            <td>Win 98+ / OSX.1+</td>\n" +
        "                                            <td>1.8</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Seamonkey 1.1</td>\n" +
        "                                            <td>Win 98+ / OSX.2+</td>\n" +
        "                                            <td>1.8</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Gecko</td>\n" +
        "                                            <td>Epiphany 2.20</td>\n" +
        "                                            <td>Gnome</td>\n" +
        "                                            <td>1.8</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Webkit</td>\n" +
        "                                            <td>Safari 1.2</td>\n" +
        "                                            <td>OSX.3</td>\n" +
        "                                            <td>125.5</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Webkit</td>\n" +
        "                                            <td>Safari 1.3</td>\n" +
        "                                            <td>OSX.3</td>\n" +
        "                                            <td>312.8</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Webkit</td>\n" +
        "                                            <td>Safari 2.0</td>\n" +
        "                                            <td>OSX.4+</td>\n" +
        "                                            <td>419.3</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Webkit</td>\n" +
        "                                            <td>Safari 3.0</td>\n" +
        "                                            <td>OSX.4+</td>\n" +
        "                                            <td>522.1</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Webkit</td>\n" +
        "                                            <td>OmniWeb 5.5</td>\n" +
        "                                            <td>OSX.4+</td>\n" +
        "                                            <td>420</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Webkit</td>\n" +
        "                                            <td>iPod Touch / iPhone</td>\n" +
        "                                            <td>iPod</td>\n" +
        "                                            <td>420.1</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Webkit</td>\n" +
        "                                            <td>S60</td>\n" +
        "                                            <td>S60</td>\n" +
        "                                            <td>413</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Presto</td>\n" +
        "                                            <td>Opera 7.0</td>\n" +
        "                                            <td>Win 95+ / OSX.1+</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Presto</td>\n" +
        "                                            <td>Opera 7.5</td>\n" +
        "                                            <td>Win 95+ / OSX.2+</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Presto</td>\n" +
        "                                            <td>Opera 8.0</td>\n" +
        "                                            <td>Win 95+ / OSX.2+</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Presto</td>\n" +
        "                                            <td>Opera 8.5</td>\n" +
        "                                            <td>Win 95+ / OSX.2+</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Presto</td>\n" +
        "                                            <td>Opera 9.0</td>\n" +
        "                                            <td>Win 95+ / OSX.3+</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Presto</td>\n" +
        "                                            <td>Opera 9.2</td>\n" +
        "                                            <td>Win 88+ / OSX.3+</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Presto</td>\n" +
        "                                            <td>Opera 9.5</td>\n" +
        "                                            <td>Win 88+ / OSX.3+</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Presto</td>\n" +
        "                                            <td>Opera for Wii</td>\n" +
        "                                            <td>Wii</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Presto</td>\n" +
        "                                            <td>Nokia N800</td>\n" +
        "                                            <td>N800</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Presto</td>\n" +
        "                                            <td>Nintendo DS browser</td>\n" +
        "                                            <td>Nintendo DS</td>\n" +
        "                                            <td>8.5</td>\n" +
        "                                            <td>C/A<sup>1</sup></td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>KHTML</td>\n" +
        "                                            <td>Konqureror 3.1</td>\n" +
        "                                            <td>KDE 3.1</td>\n" +
        "                                            <td>3.1</td>\n" +
        "                                            <td>C</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>KHTML</td>\n" +
        "                                            <td>Konqureror 3.3</td>\n" +
        "                                            <td>KDE 3.3</td>\n" +
        "                                            <td>3.3</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>KHTML</td>\n" +
        "                                            <td>Konqureror 3.5</td>\n" +
        "                                            <td>KDE 3.5</td>\n" +
        "                                            <td>3.5</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Tasman</td>\n" +
        "                                            <td>Internet Explorer 4.5</td>\n" +
        "                                            <td>Mac OS 8-9</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>X</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Tasman</td>\n" +
        "                                            <td>Internet Explorer 5.1</td>\n" +
        "                                            <td>Mac OS 7.6-9</td>\n" +
        "                                            <td>1</td>\n" +
        "                                            <td>C</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Tasman</td>\n" +
        "                                            <td>Internet Explorer 5.2</td>\n" +
        "                                            <td>Mac OS 8-X</td>\n" +
        "                                            <td>1</td>\n" +
        "                                            <td>C</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Misc</td>\n" +
        "                                            <td>NetFront 3.1</td>\n" +
        "                                            <td>Embedded devices</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>C</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Misc</td>\n" +
        "                                            <td>NetFront 3.4</td>\n" +
        "                                            <td>Embedded devices</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>A</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Misc</td>\n" +
        "                                            <td>Dillo 0.8</td>\n" +
        "                                            <td>Embedded devices</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>X</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Misc</td>\n" +
        "                                            <td>Links</td>\n" +
        "                                            <td>Text only</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>X</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Misc</td>\n" +
        "                                            <td>Lynx</td>\n" +
        "                                            <td>Text only</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>X</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Misc</td>\n" +
        "                                            <td>IE Mobile</td>\n" +
        "                                            <td>Windows Mobile 6</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>C</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Misc</td>\n" +
        "                                            <td>PSP browser</td>\n" +
        "                                            <td>PSP</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>C</td>\n" +
        "                                        </tr>\n" +
        "                                        <tr>\n" +
        "                                            <td>Other browsers</td>\n" +
        "                                            <td>All others</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>-</td>\n" +
        "                                            <td>U</td>\n" +
        "                                        </tr>\n" +
        "                                        </tbody>\n" +
        "                                        <tfoot>\n" +
        "                                        <tr>\n" +
        "                                            <th>Rendering engine</th>\n" +
        "                                            <th>Browser</th>\n" +
        "                                            <th>Platform(s)</th>\n" +
        "                                            <th>Engine version</th>\n" +
        "                                            <th>CSS grade</th>\n" +
        "                                        </tr>\n" +
        "                                        </tfoot>\n" +
        "                                    </table>\n" +
        "                                </div>";
}