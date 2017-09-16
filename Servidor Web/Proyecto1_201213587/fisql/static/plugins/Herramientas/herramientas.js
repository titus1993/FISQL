function ejecutarUSQL(){
    $.post("/fisql/ejecutarUsql",
    {
        usqlCode: editor.getValue()
    })
        .done(function(json_respuesta, status){
            $('#output-datos').val($('#output-datos').val()+json_respuesta['salida']);
            editor.setValue(json_respuesta['salida']+ "\n");
        });

}