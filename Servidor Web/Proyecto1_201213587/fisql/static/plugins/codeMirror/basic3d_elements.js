CodeMirror.defineSimpleMode("basic3d_elements", {
    // The start state contains the rules that are intially used
    start: [
        // The regex matches the token, the token property contains the type
        { regex: /"(?:[^\\]|\\.)*?(?:"|$)/, token: "string" },
        // You can match multiple tokens at once. Note that the captured
        // groups must span the whole string in this case
        
        // Rules are matched in the order in which they appear, so there is
        // no ambiguity between this one and the one above
        {
            regex: /(?:crear|otorgar|permisos|denegar|usar|alterar|agregar|quitar|base_datos|tabla|procedimiento|funcion|objeto|usuario|actualizar|ordenar_por|asc|desc|borrar|seleccionar|donde|eliminar|insertar|en|valores|bool|integer|double|text|date|datetime|declarar|si|sino|selecciona|caso|defecto|para|mientras|detener|imprimir|fecha|fecha_hora|contar|backup|usqldump|completo|restaurar|retorno)\b/,
            token: "keyword"
        },
        { regex: /verdadero|falso|nulo|no nulo|llave_primaria|llave_foranea|unico|autoincrementable/, token: "atom" },
        {
            regex: /0x[a-f\d]+|(?:\.\d+|\d+\.?\d*)(?:e[-+]?\d+)?/i,
            token: "number"
        },
        // A next property will cause the mode to move to a different state
        { regex: /#\*/, token: "comment", next: "comment" },
        { regex: /#.*/, token: "comment" },

        { regex: /[-+\/*^=<>!|\?&]+/, token: "operator" },
        // indent and dedent properties guide autoindentation
        { regex: /[\{\[\(]/, indent: true },
        { regex: /[\}\]\)]/, dedent: true },
        { regex: /[a-zA-Z$][\w$]*/, token: "bracket" },
        // You can embed other modes with the mode property. This rule
        // causes all code between << and >> to be highlighted with the XML
        // mode.
        { regex: /<</, token: "meta", mode: { spec: "xml", end: />>/ } }
    ],
    // The multi-line comment state.
    comment: [
        { regex: /.*?\*#/, token: "comment", next: "start" },
        { regex: /.*/, token: "comment" }
    ],
    // The meta property contains global information about the mode. It
    // can contain properties like lineComment, which are supported by
    // all modes, and also directives like dontIndentStates, which are
    // specific to simple modes.
    meta: {
        dontIndentStates: ["comment"],
        lineComment: "#"
    }
});