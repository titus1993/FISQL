function ejecutarBacup(){
    $.post("/fisql/ejecutarBacup")
        .done(function (json_respuesta, status) {
            $('#output-datos').val($('#output-datos').val() + json_respuesta['salida']);


            //asdfasdfcodigo para meter los datos donde corresponden
            var mensaje = json_respuesta['mensaje'];

            var element = document.createElement('a');
            element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(mensaje));
            element.setAttribute('download', 'bacup.txt');

            element.style.display = 'none';
            document.body.appendChild(element);

            element.click();

            document.body.removeChild(element);

        });
}

function ejecutarRestaurar(cadena){
    $.post("/fisql/ejecutarUsql",
        {
            usqlCode: cadena
        })
        .done(function (json_respuesta, status) {
            $('#output-datos').val($('#output-datos').val() + json_respuesta['salida']);


            //asdfasdfcodigo para meter los datos donde corresponden
            var mensaje = json_respuesta['mensaje'];
            var reportes = json_respuesta['reporte'];
            var hist = json_respuesta['historial'];
            var ejecucion = json_respuesta['ejecucion'];

            editormensajes.setValue(String(mensaje));
            historial.setValue(String(hist));
            console.log('antes del if')
            if(reportes != ""){
                var report = '';
                reportes = String(reportes);
                for(var i = 0; i < reportes.length; i++){
                    // noinspection JSAnnotator
                    console.log(reportes.charAt(i));
                    // noinspection JSAnnotator
                    if(reportes.charAt(i) == '§'){
                        agregarReporte(report);
                        report = '';
                    }else{
                        report += reportes.charAt(i);
                    }
                }
                console.log('hay reportes');
            }
            console.log('despues del if');

            editormensajes.refresh();
        });
}

function ejecutarUSQL() {
    $.post("/fisql/ejecutarUsql",
        {
            usqlCode: editor.getValue()
        })
        .done(function (json_respuesta, status) {
            $('#output-datos').val($('#output-datos').val() + json_respuesta['salida']);


            //asdfasdfcodigo para meter los datos donde corresponden
            var mensaje = json_respuesta['mensaje'];
            var reportes = json_respuesta['reporte'];
            var hist = json_respuesta['historial'];
            var ejecucion = json_respuesta['ejecucion'];

            editormensajes.setValue(String(mensaje));
            historial.setValue(String(ejecucion));
            console.log('antes del if')
            if(reportes != ""){
                var report = '';
                reportes = String(reportes);
                for(var i = 0; i < reportes.length; i++){
                    // noinspection JSAnnotator
                    console.log(reportes.charAt(i));
                    // noinspection JSAnnotator
                    if(reportes.charAt(i) == '§'){
                        agregarReporte(report);
                        report = '';
                    }else{
                        report += reportes.charAt(i);
                    }
                }
                console.log('hay reportes');
            }



            console.log('despues del if');

            editormensajes.refresh();
        });
}

function ejecutarReporte() {
    $.post("/fisql/ejecutarReporte",
        {
            reporteCode: editorentrada.getValue()
        })
        .done(function (json_respuesta, status) {
            $('#output-datos').val($('#output-datos').val() + json_respuesta['salida']);


            //asdfasdfcodigo para meter los datos donde corresponden
            var mensaje = json_respuesta['mensaje'];
            var reportes = json_respuesta['reporte'];
            var hist = json_respuesta['historial'];
            var ejecucion = json_respuesta['ejecucion'];

            //editormensajes.setValue(String(mensaje));
            //historial.setValue(String(hist));
            console.log('antes del if')
            editormensajes.setValue(String(mensaje));
            historial.setValue(String(hist));
            if(reportes != ""){
                console.log('hay reportes')
                editorsalida.setValue(reportes);
            }
            console.log('despues del if')

            //editormensajes.refresh();
        });
}



var reporte = 1;

function agregarReporte(cadena) {


    $(function () {
        var theDiv = document.getElementById('seccionContenido');
    var newNode = document.createElement('div');
    newNode.setAttribute("id", "caja2");
    newNode.className += ' box box-info';
    newNode.innerHTML += "<div class=\"box-header\">\n" +
        "                                    <i class=\"fa fa-table\"></i>\n" +
        "\n" +
        "                                    <h3 class=\"box-title\">Reporte USQL " + reporte + "</h3>\n" +
        "                                    <!-- tools box -->\n" +
        "                                    <div class=\"pull-right box-tools\">\n" +
        "                                        <button type=\"button\" class=\"btn btn-info btn-sm\" data-widget=\"collapse\"\n" +
        "                                                data-toggle=\"tooltip\" title=\"Remove\"><i class=\"fa fa-minus\"></i>\n" +
        "                                        </button>\n" +
        "<button type=\"button\" class=\"btn btn-info btn-sm\" data-widget=\"remove\" data-toggle=\"tooltip\"\n" +
        "                        title=\"Remove\">\n" +
        "                  <i class=\"fa fa-times\"></i></button>"+
        "\n" +
        "                                    </div>\n" +
        "                                    <!-- /. tools -->\n" +
        "                                </div>\n" +
        "                                <!-- /.box-header -->\n" +
        "                                <div class=\"box-body\">\n" +
        "                                    <table id=\"resultado" + reporte + "\" class=\"table table-bordered table-striped\">\n" +
        cadena +
        "                                    </table>\n" +
        "                                </div>\n" +
        "                                <!-- /.box-body -->";
    theDiv.appendChild(newNode);
        $('#resultado' + reporte).DataTable()
        $('.box').boxWidget()
        reporte++;
    })
}