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
            regex: /(?:crear|usar|base_datos|tabla|procedimiento|funcion|objeto|eliminar|insertar|en|autoincrementable|llave_primaria|llave_foranea|nulo|no|bool|integer|double|text|date|datetime|num|str|element|array|of|create|if|then|else|switch|case|default|break|continue|return|while|do|repeat|until|for|loop|count|whilex|getBool|getNum|outStr|outNum|inStr|inNum|void|getRandom|getLenght|throws)\b/,
            token: "keyword"
        },
        { regex: /verdadero|falso|NULL|NullPointerException|MissingReturnStatement|ArithmeticException|StackOverFlowException|HeapOverFlowException|PoolOverFlowException/, token: "atom" },
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