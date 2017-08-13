options {
MULTI=true;
STATIC = false;
OUTPUT_DIRECTORY="C:\\Users\\Kristhal\\Documents\\NetBeansProjects\\[Compi2A-]Proyecto1_201314655\\src\\compi2a\\proyecto1_201314655\\";
}

PARSER_BEGIN(Analisis)
package compi2a.proyecto1_201314655;

public class Analisis {
  public static void main(String args[]) throws ParseException {
    Analisis parser = new Analisis(System.in);
    parser.S();
    System.out.println("Exito!!");
  }
}
PARSER_END(Analisis)

TOKEN:
{
    
    <MAS:"+"> {System.out.println(image);}
    |<MENOS:"-"> {System.out.println(image);}
    |<POR:"*"> {System.out.println(image);}
    |<DIVIDIR:"/"> {System.out.println(image);}
    |<POTENCIA:"^"> {System.out.println(image);}
    |<AUMENTO:"++"> {System.out.println(image);}
    |<DECREMENTO:"--"> {System.out.println(image);}
    |<SUMASIMPLIFICADA:"+="> {System.out.println(image);}
    |<RESTASIMPLIFICADA:"-="> {System.out.println(image);}
}

TOKEN:
{
    
    <PAR_IZQ:"(">{System.out.println(image);}
    |<PAR_DER:")">{System.out.println(image);}
    |<LLAVE_IZQ:"{">{System.out.println(image);}
    |<LLAVE_DER:"}">{System.out.println(image);}
    |<COR_IZQ:"[">{System.out.println(image);}
    |<COR_DER:"]">{System.out.println(image);}
    |<PC:";">{System.out.println(image);}
    |<COMA:",">{System.out.println(image);}
    |<DOSP:":">{System.out.println(image);}
    |<IGUAL:"=">{System.out.println(image);}
    |<FINSEN:"$">{System.out.println(image);}
    |<IABRE:"\u00bf">{System.out.println(image);}
    |<ICIERRA:"?">{System.out.println(image);}
}

TOKEN:
{
  
    <IGUALACION:"=="> {System.out.println(image);}
    |<MENOR:"<"> {System.out.println(image);}
    |<MAYOR:">"> {System.out.println(image);}
    |<MENORIGUAL:"<="> {System.out.println(image);}
    |<MAYORIGUAL:">="> {System.out.println(image);}
    |<DIFERENCIACION:"!="> {System.out.println(image);}
    |<NULO:"!&¡"> {System.out.println(image);}
    |<OR:"||"> {System.out.println(image);}
    |<AND:"&&"> {System.out.println(image);}
    |<NAND:"!&&"> {System.out.println(image);}
    |<NOR:"!||"> {System.out.println(image);}
    |<XOR:"&|"> {System.out.println(image);}
    |<NOT:"!"> {System.out.println(image);}

}


TOKEN:
{
  
  <T_ENTERO: ("entero"|"Entero")> {System.out.println(image);}
  |<T_CADENA: ("cadena"|"Cadena")> {System.out.println(image);}
  |<T_BOOL: ("boolean"|"Boolean")> {System.out.println(image);}
  |<T_CARACTER:("Caracter"|"caracter")> {System.out.println(image);}
  |<T_DOBLE: ("doble"|"Doble")> {System.out.println(image);}
}


TOKEN:
{
  
    <LIENZO:("Lienzo"|"lienzo")> {System.out.println(image);}
    |<EXTIENDE:("Extiende"|"extiende")> {System.out.println(image);}
    |<PUBLICO:("publico"|"Publico")> {System.out.println(image);}
    |<PRIVADO:("Privado"|"privado")> {System.out.println(image);}
    |<PROTEGIDO:("protegido"|"Protegido")> {System.out.println(image);}
    |<CONSERVAR:("conservar"|"Conservar")> {System.out.println(image);}
    |<VARIABLE:("Var"|"var")> {System.out.println(image);}
    |<ARREGLO:("Arreglo"|"arreglo")> {System.out.println(image);}
    |<SI:("si"|"Si")> {System.out.println(image);}
    |<SINO:("sino"|"Sino")> {System.out.println(image);}
    |<COMPROBAR:("Comprobar"|"comprobar")> {System.out.println(image);}
    |<CASO:("Caso"|"caso")> {System.out.println(image);}
    |<DEFECTO:("Defecto"|"defecto")> {System.out.println(image);}
    |<SALIR:("Salir"|"salir")> {System.out.println(image);}
    |<PARA:("Para"|"para")> {System.out.println(image);}
    |<MIENTRAS:("Mientras"|"mientras")> {System.out.println(image);}
    |<HACER:("Hacer"|"hacer")> {System.out.println(image);}
    |<CONTINUAR:("Continuar"|"continuar")> {System.out.println(image);}
    |<RETORNA:("Retorna"|"retorna")> {System.out.println(image);}
    |<PINTA_PUNTO:("pintar_p"|"Pintar_P")> {System.out.println(image);}
    |<PINTA_OR:("Pintar_OR"|"pintar_or")> {System.out.println(image);}
    |<PINTA_CADENA:("Pintar_S"|"pintar_s")> {System.out.println(image);}
    |<PRINCIPAL:("Principal"|"principal")> {System.out.println(image);}
    |<ORDENAR:("ordenar"|"Ordenar")> {System.out.println(image);}
    |<ASCENDENTE:("ascendente"|"Ascendente")> {System.out.println(image);}
    |<DESCENDENTE:("Descendente"|"descendente")> {System.out.println(image);}
    |<PARES:("Pares"|"pares")> {System.out.println(image);}
    |<IMPARES:("Impares"|"impares")> {System.out.println(image);}
    |<PRIMOS:("primos"|"Primos")> {System.out.println(image);}
    |<SUMARIZAR:("sumarizar"|"Sumarizar")> {System.out.println(image);}
    |<TRUE:(("verdadero")|("true"))> {System.out.println(image);}
    |<FALSE:(("falso")|("false"))> {System.out.println(image);}
    |<TIPO:(("Tipo")|("tipo"))> {System.out.println(image);}
}

TOKEN:
{
  
    <ENTERO: (["0"-"9"])+ > {System.out.println(image);}
    |<#NUMERO: ["0"-"9"]>
    |<DECIMAL: (<NUMERO>)+(".")((<NUMERO>){0,6})> {System.out.println(image);}
    |<ID: (["a"-"z","A"-"Z"])(["a"-"z","A"-"Z","0"-"9","_"])*> {System.out.println(image);}
    |<CARACTER:(("'" ~["\n","\t","\r"] "'")|"'^t'"|"'^n'"|"^^"|"'^''")> {System.out.println(image);}
    |<CADENA:
      "\"" ((~["\"","\\","\n","\r","\t"])
            |("\\"
            ( ["n","t","b","r","f","\\","'","\""]
            |("#"(["A"-"F"]|["0"-"9"]){6}))
            ))*"\""
     > {System.out.println(image);}
}

SKIP: 
{
  " "
| "\n"
| "\r"
| "\t"
| <COMENTARIO_LINEA: ">>" (~[ "\n", "\r" ])*
    (
      "\n"
    | "\r"
    | "\r\n"
    ) >{System.out.println(image);}
| <COMENTARIO_MULTI: "<-" (~[ "-" ])* "-"
    (
      ~[ "/" ] (~[ "-" ])* "-"
    )*
    ">" > {System.out.println(image);}
    
}


Nodo S():
{Nodo i;}
{
    i=Inicio() <EOF> { 
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("Lienzo");
                        Nodo hijo = (Nodo) i;
                        nodo.AddHijos(hijo);
                        return nodo;
                   }
}

Nodo Inicio():
{Nodo body, nodo; Token name, id1, id2; String tipo, tm="";}
{
    {nodo = new Nodo();}
    (tipo=Tipo_Metodo(){tm= tipo;})? <LIENZO> name=<ID> 
    {
        nodo.setEtiqueta(name.image);
        nodo.setCadena(name.image);
        nodo.setTMetodo(tm);        
    } 
    (<EXTIENDE>id1=<ID>{nodo.AddExtiende(id1.image);}(<COMA>id2=<ID>{nodo.AddExtiende(id2.image);})*)? <IABRE> (body=PreCuerpo(){
        Nodo n1 = new Nodo();
        n1.setEtiqueta("prueba");
        Nodo cp = (Nodo) body;
        n1.AddHijos(cp);
        nodo.AddHijos(n1);
        })* <ICIERRA>
    {
        return nodo;
    }
}

String Tipo_Metodo():
{}
{
    <PUBLICO> { return "publico";}
    |<PRIVADO> { return "privado";} 
    |<PROTEGIDO> { return "protegido";}
}

Nodo PreCuerpo():
{Nodo body, a, nodo;}
{
    {nodo = new Nodo();}
    a=Asignacion()<FINSEN>{
        nodo.setEtiqueta("asignacion");
        Nodo n1 = (Nodo) a;
        nodo.AddHijos(n1);
    }
    |(PreAccion() body=Cuerpo())
    {
        nodo = (Nodo) body; 
    }
    {return nodo;}
}

Nodo PreAccion():
{}
{
    (<CONSERVAR>)? (Tipo_Metodo())?
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("preaccion");
        return nodo;
    }
}

Nodo Cuerpo():
{Nodo m, d;}
{
    { Nodo nodo = new Nodo();
      nodo.setEtiqueta("cuerpo");
    }
    (m=Metodo()
    {
        Nodo metodo = new Nodo();
        metodo.setEtiqueta("metodo");
        Nodo n1 = (Nodo) m;
        metodo.AddHijos(n1);
        nodo.AddHijos(metodo);
       
    }
    |d=Declaracion()
    {
        Nodo declara = new Nodo();
        declara.setEtiqueta("declaracion");
        Nodo n1 = (Nodo) d;
        declara.AddHijos(n1);
        nodo.AddHijos(declara);
    }
    |Principal()
    { 
    nodo.setEtiqueta("Principal");
    }
    )  
    {return nodo;}
}

Nodo Principal():
{}
{
    <PRINCIPAL> <PAR_IZQ> <PAR_DER> <IABRE> Lista_Sentencias() <ICIERRA>
    {Nodo nodo = new Nodo(); 
    nodo.setEtiqueta("Principal");
    return nodo;}
}  

Nodo Metodo():
{String tipom; Boolean conserva; Nodo parametro, sentencia, retorno, nodo, tipo; Token id;}
{
    {nodo= new Nodo();}
    (tipo=TipoVariable(){nodo.setTipo(tipo.getTipo());})? 
    (<COR_IZQ><COR_DER>)? 
    id=<ID>{nodo.setCadena(id.image); nodo.setEtiqueta(id.image);} <PAR_IZQ> 
    (parametro=Lista_Parametros(){
                                    Nodo n1 = (Nodo) parametro; 
                                    Nodo para = new Nodo();
                                    para.setEtiqueta("parametros");
                                    para.AddHijos(n1);
                                    nodo.AddHijos(para);
                                 })? <PAR_DER> <IABRE> 
    sentencia=Lista_Sentencias() {Nodo n2 = (Nodo) sentencia; nodo.AddHijos(n2);}
    (retorno=Retornar(){Nodo n3 = (Nodo) retorno; nodo.AddHijos(n3);})? <ICIERRA>
    {return nodo;}
}

Nodo Lista_Parametros():
{Nodo tipo, lst; Token id;}
{
    {   Nodo nodo= new Nodo();
        nodo.setEtiqueta("parametros");
    }
    tipo=TipoVariable() id=<ID>
    {
        Nodo n1 = new Nodo();
        n1.setEtiqueta(id.image);
        n1.setCadena(id.image);
        n1.setTipo(tipo.getTipo());
        nodo.AddHijos(n1);
    } 
    (<COMA>lst=Lista_Parametros()
    {
        Nodo n2 = (Nodo) lst;
        nodo.AddHijos(n2);
    }
    )?
    
    {return nodo;}
}

Nodo Retornar():
{Nodo e1;}
{
    <RETORNA> (e1=L()) <FINSEN>
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("retorna");
        Nodo n = (Nodo) e1;
        nodo.AddHijos(e1);
        return nodo; 
    }
}

Nodo Lista_Sentencias():
{Nodo sent, lst;}
{
    sent=Sentencias()
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("sentencias");
        Nodo n1 = (Nodo) sent;
        nodo.AddHijos(n1);
    }
    (LOOKAHEAD(Sentencias()) lst=Lista_Sentencias(){Nodo n2 = (Nodo) lst; nodo.AddHijos(n2);})?
    {return nodo;}
}

Nodo Sentencias():
{Nodo d,a,i,c, s, p, m, hm, co, pi, me;}
{
    LOOKAHEAD(2)
    PreAccion() d=Declaracion() {Nodo nodo = (Nodo) d; return nodo;}
    |a=Asignacion() <FINSEN> {Nodo nodo = (Nodo) a; return nodo;}
    |i=If() {Nodo nodo = (Nodo) i; return nodo;}
    |c=Comprobar() {Nodo nodo = (Nodo) c; return nodo;}
    |s=Salir() {Nodo nodo = (Nodo) s; return nodo;}
    |p=Para() {Nodo nodo = (Nodo) p; return nodo;}
    |m=Mientras() {Nodo nodo = (Nodo) m; return nodo;}
    |hm=HacerMientras() {Nodo nodo = (Nodo) hm; return nodo;}
    |co=Continuar() {Nodo nodo = (Nodo) co; return nodo;}
    |pi=Pintar() {Nodo nodo = (Nodo) pi; return nodo;}
    |me=MetodosArreglos() {Nodo nodo = (Nodo) me; return nodo;}
    
}


Nodo Declaracion():
{Nodo tipo, e1,e3, nodo, n1, n2; Boolean conse=false; String type; Token id1, id2;}
{
    {   
        nodo = new Nodo();
        nodo.setEtiqueta("declaracion");
    }
    <VARIABLE> TipoVariable() (DeclaraVariable()|DeclaraArreglo())
    {return nodo;}
}

Nodo DeclaraVariable():
{}
{
    ((<ID>[<IGUAL> EXP()] (<COMA><ID> [<IGUAL> EXP()])*)) <FINSEN>
    {
        Nodo nodo = new Nodo(); 
        nodo.setEtiqueta("DeclaraVariable");
        return nodo;
    }
    
}

Nodo DeclaraArreglo():
{}
{
    <ARREGLO> <ID>(<COMA><ID>)* (<COR_IZQ> E() <COR_DER>)+ (<IGUAL> (AsignaDeclara()|L()))? <FINSEN>
    {
        Nodo nodo = new Nodo(); 
        nodo.setEtiqueta("DeclaraArreglo");
        return nodo;
    }
}

Nodo AsignaDeclara():
{}
{
    <LLAVE_IZQ> (AsignaDeclara() (<COMA> AsignaDeclara())* | Otra()) <LLAVE_DER>
    {
        Nodo nodo = new Nodo(); 
        nodo.setEtiqueta("AsignaDeclara");
        return nodo;
    }
}

Nodo Otra():
{}
{
    E() (<COMA> E())*
    {
        Nodo nodo = new Nodo(); 
        nodo.setEtiqueta("AsignaDeclara");
        return nodo;
    }
}

Nodo Asignacion():
{Nodo asig, nodo; Token t;}
{
    {nodo = new Nodo();
     nodo.setEtiqueta("asignacion");}
    t=<ID>(PostAsignacion()|AsignacionArreglo()|LlamadaFuncion())
    {return nodo;}
}

Nodo PostAsignacion():
{Nodo asig, nodo;}
{
    {nodo = new Nodo();}
    (asig=LstAsignacion()
    {
        nodo = (Nodo) asig;
        
    }
    | <AUMENTO> 
    {
        nodo.setEtiqueta("aumento");
        
    }
    | <DECREMENTO>
    {
        nodo.setEtiqueta("decremento");
        
    })
    {return nodo;}

}

Nodo LstAsignacion():
{Nodo e1,e2,e3;}
{
    <IGUAL> e1=EXP()
    {
        Nodo nodo= new Nodo();
        nodo.setEtiqueta("igual");
        Nodo n1 = (Nodo) e1;
        nodo.AddHijos(n1);
        return nodo;
    }
    |<SUMASIMPLIFICADA> e2=EXP()
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("sumasimplificada");
        Nodo n1 = (Nodo) e2;
        nodo.AddHijos(n1);
        return nodo;
    }
    |<RESTASIMPLIFICADA> e3=EXP()
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("restasimplificada");
        Nodo n1 = (Nodo) e3;
        nodo.AddHijos(n1);
        return nodo;
    }
}


Nodo AsignacionArreglo():
{}
{
    <ID> (<COR_IZQ> E()  <COR_DER>)* <IGUAL> ((<ID>(<COR_IZQ> E() <COR_DER>)*)|(E())) <FINSEN>
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("AsignaArreglo");
        return nodo;
    }
}

Nodo TipoVariable():
{}
{
     <T_ENTERO> {
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("entero");
                    nodo.setTipo("entero");
                    return nodo;
                }
    |<T_CADENA> {
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("cadena");
                    nodo.setTipo("cadena");
                    return nodo;
                }
    |<T_BOOL>   {
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("bool");
                    nodo.setTipo("bool");
                    return nodo;
                }
    |<T_CARACTER> {
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("caracter");
                    nodo.setTipo("caracter");
                    return nodo;
                  }
    |<T_DOBLE>    {
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("doble");
                    nodo.setTipo("doble");
                    return nodo;
                  }
}


Nodo If():
{Nodo cond, lst, elsen;}
{
    <SI> <PAR_IZQ> cond=EXP() <PAR_DER> <IABRE> lst=Lista_Sentencias() 
    {
        Nodo ifpadre = new Nodo();
        ifpadre.setEtiqueta("if-padre");
        Nodo si = new Nodo();
        si.setEtiqueta("if");
        Nodo condicion= (Nodo) cond;
        Nodo sentencias = (Nodo) lst;
        ifpadre.AddHijos(cond);
        ifpadre.AddHijos(lst);
    } 
    
    <ICIERRA> (elsen=Elseif()
    { 
        ifpadre.AddHijos(elsen);
    }
    )?
    {return ifpadre;}
}

Nodo Elseif():
{Nodo lst;}
{
    <SINO><IABRE> lst=Lista_Sentencias() <ICIERRA> 
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("sino");
        Nodo n1 = (Nodo) lst;
        nodo.AddHijos(n1);
        return nodo;
    }
}

Nodo Comprobar():
{Nodo e1, lst;}
{
    <COMPROBAR> e1=E() <IABRE> lst=Lista_Casos() <ICIERRA>
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("comprobar");
        Nodo cond = (Nodo) e1;
        Nodo lista = (Nodo) lst;
        nodo.AddHijos(cond);
        nodo.AddHijos(lista);
        return nodo;
    }
}

Nodo Lista_Casos():
{Nodo ca, lst;}
{
    ca=Casos() 
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("Lista_Casos");
        Nodo n1 = (Nodo) ca;
        nodo.AddHijos(n1);
    }

    (lst=Lista_Casos(){
        Nodo lista= (Nodo) lst;
        nodo.AddHijos(lista);
    })?
    
    { return nodo;}
    
}

Nodo Casos():
{Nodo e1, sent1, sent2;}
{
    <CASO> e1=E() <DOSP> sent1=Lista_Sentencias(){
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("caso");
        Nodo n1 = (Nodo) e1;
        Nodo n2 = (Nodo) sent1;
        nodo.AddHijos(n1);
        nodo.AddHijos(n2);
        return nodo;
    }
    |<DEFECTO> <DOSP> sent2=Lista_Sentencias()
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("defecto");
        Nodo n1 = (Nodo) sent2;
        nodo.AddHijos(n1);
        return nodo;
    }

}

Nodo Salir():
{Token t, t1;}
{
    t=<SALIR> <FINSEN>
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("salir");
        nodo.setCadena(t.image);
        nodo.setColumna(t.beginColumn);
        nodo.setLinea(t.beginLine);
        return nodo;
    }
    |<COR_IZQ>t1=<SALIR><COR_DER><FINSEN>
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("salir");
        nodo.setCadena(t1.image);
        nodo.setColumna(t1.beginColumn);
        nodo.setLinea(t1.beginLine);
        return nodo;
    }
}


Nodo Para():
{Nodo asig, cond, exp, sent;}
{
    <PARA> <PAR_IZQ> asig=Asignacion() <PC> cond=EXP() <PC> exp=Asignacion() <PAR_DER> <IABRE> sent=Lista_Sentencias() <ICIERRA>
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("para");
        Nodo n1 = (Nodo) asig;
        Nodo n2 = (Nodo) cond;
        Nodo n3 = (Nodo) exp;
        Nodo n4 = (Nodo) sent;
        nodo.AddHijos(n1);
        nodo.AddHijos(n2);
        nodo.AddHijos(n3);
        nodo.AddHijos(n4);
        return nodo;
    }
}

Nodo Mientras():
{Nodo cond, sent;}
{
    <MIENTRAS> <PAR_IZQ> cond=EXP() <PAR_DER> <IABRE> sent=Lista_Sentencias() <ICIERRA>{
        Nodo nodo= new Nodo();
        nodo.setEtiqueta("mientras");
        Nodo condicion = (Nodo) cond;
        Nodo sentencias = (Nodo) sent;
        nodo.AddHijos(condicion);
        nodo.AddHijos(sentencias);
        return nodo; 
    }
}

Nodo HacerMientras():
{Nodo lst, condicion;}
{
    <HACER> <IABRE> lst=Lista_Sentencias() <ICIERRA> <MIENTRAS> <PAR_IZQ> condicion=EXP() <PAR_DER> <FINSEN> 
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("hacer");
        Nodo n1 = (Nodo) lst;
        nodo.AddHijos(n1);
        Nodo cond = new Nodo();
        cond.setEtiqueta("condicion");
        Nodo n2 = (Nodo) condicion;
        cond.AddHijos(n2);
        nodo.AddHijos(cond);
        return nodo;
    }
    
}

Nodo Continuar():
{}
{
    <CONTINUAR> <FINSEN>
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("continuar");
        return nodo;
    }
}


//PONERLE ASIGNACION | E A TODAS LAS PRODUCCIONES
Nodo Pintar():
{Nodo pp1,pp2,pp3,pp4,po1,po2,po3,po4,po5,po6,pc1,pc2,pc3,pc4;}
{
    <PINTA_PUNTO> <PAR_IZQ> (Asignacion()|E()) <COMA> (Asignacion()|E()) <COMA> (Asignacion()|E()) <COMA> (Asignacion()|E()) <PAR_DER> <FINSEN>
                    {
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("Pinta_P");
                        
                        Nodo x = new Nodo();
                        x.setEtiqueta("x");
                        //Nodo hx = (Nodo) pp1;
                        //x.AddHijos(hx);
                        nodo.AddHijos(x);
                            
                        Nodo y = new Nodo();
                        y.setEtiqueta("y");
                        //Nodo hy = (Nodo) pp2;
                        //y.AddHijos(hy);
                        nodo.AddHijos(y);
                        
                        Nodo color = new Nodo();
                        color.setEtiqueta("color");
                        //Nodo hcolor = (Nodo) pp3;
                        //color.AddHijos(hcolor);
                        nodo.AddHijos(color);

                        Nodo diametro = new Nodo();
                        diametro.setEtiqueta("diametro");
                        //Nodo hdiametro = (Nodo) pp4;
                        //diametro.AddHijos(hdiametro);
                        nodo.AddHijos(diametro);
                        
                        return nodo;
                     }

    |<PINTA_OR>  <PAR_IZQ> (Asignacion()|E()) <COMA> (Asignacion()|E()) <COMA> (Asignacion()|E()) <COMA> (Asignacion()|E()) <COMA> (Asignacion()|E()) <COMA> (Asignacion()|E()) <PAR_DER> <FINSEN>
                    {
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("Pinta_OR");

                        Nodo x = new Nodo();
                        x.setEtiqueta("x");
                        //Nodo hx = (Nodo) po1;
                        //x.AddHijos(hx);
                        nodo.AddHijos(x);
                            
                        Nodo y = new Nodo();
                        y.setEtiqueta("y");
                        //Nodo hy = (Nodo) po2;
                        //y.AddHijos(hy);
                        nodo.AddHijos(y);
                        
                        Nodo color = new Nodo();
                        color.setEtiqueta("color");
                        //Nodo hcolor = (Nodo) po3;
                        //color.AddHijos(hcolor);
                        nodo.AddHijos(color);

                        Nodo ancho = new Nodo();
                        ancho.setEtiqueta("ancho");
                        //Nodo hancho = (Nodo) po4;
                        //ancho.AddHijos(hancho);
                        nodo.AddHijos(ancho);

                        Nodo alto = new Nodo();
                        alto.setEtiqueta("alto");
                        //Nodo halto = (Nodo) po5;
                        //alto.AddHijos(halto);
                        nodo.AddHijos(alto);

                        Nodo figura = new Nodo();
                        figura.setEtiqueta("figura");
                        //Nodo hfigura = (Nodo) po6;
                        //figura.AddHijos(hfigura);
                        nodo.AddHijos(figura);
                        
                        return nodo;
                        
                     }
    |<PINTA_CADENA> <PAR_IZQ> (Asignacion()|E()) <COMA> (Asignacion()|E()) <COMA> (Asignacion()|E()) <COMA> (Asignacion()|E()) <PAR_DER> <FINSEN>
                      {
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("Pinta_S");
                        
                        Nodo x = new Nodo();
                        x.setEtiqueta("x");
                        //Nodo hx = (Nodo) pc1;
                        //x.AddHijos(hx);
                        nodo.AddHijos(x);
                            
                        Nodo y = new Nodo();
                        y.setEtiqueta("y");
                        //Nodo hy = (Nodo) pc2;
                        //y.AddHijos(hy);
                        nodo.AddHijos(y);
                        
                        Nodo color = new Nodo();
                        color.setEtiqueta("color");
                        //Nodo hcolor = (Nodo) pc3;
                        //color.AddHijos(hcolor);
                        nodo.AddHijos(color);

                        Nodo cadena = new Nodo();
                        cadena.setEtiqueta("diametro");
                        //Nodo hcadena = (Nodo) pc4;
                        //cadena.AddHijos(hcadena);
                        nodo.AddHijos(cadena);
                        
                        return nodo;
                       }
}

Nodo MetodosArreglos():
{Token i1; Nodo tipo;}
{
    <ORDENAR> <PAR_IZQ> <ARREGLO> i1=<ID> <COMA> <TIPO> tipo=TiposOrden() <PAR_DER> <FINSEN> 
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("ordenar");
        Nodo izq = new Nodo();
        izq.setEtiqueta(i1.image);
        izq.setCadena(i1.image);
        izq.setColumna(i1.beginColumn);
        izq.setLinea(i1.beginLine);
        Nodo der = (Nodo) tipo;
        nodo.AddHijos(izq);
        nodo.AddHijos(der);
        return nodo;
        
    }
    |<SUMARIZAR> <PAR_IZQ> (<ID>|( <LLAVE_IZQ> E() (<COMA>E())* <LLAVE_DER> )) <PAR_DER> <FINSEN>
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("sumarizar");
        //Nodo n = (Nodo) e2;
        //nodo.AddHijos(n);
        return nodo;
    }
}

Nodo TiposOrden():
{}
{
    <ASCENDENTE>{
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("ascendente");
                    return nodo;
                }

    |<DESCENDENTE>{
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("descendente");
                    return nodo;
                }

    |<PARES>{
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("pares");
                    return nodo;
                }

    |<IMPARES>{
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("impares");
                    return nodo;
                }

    |<PRIMOS>{
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("primos");
                    return nodo;
                }
}


Nodo EXP():
{Nodo g1, g2, g3, g4;}
{
    g1=G()(<OR>g2=G() {
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("or");
                        Nodo izq = (Nodo) g1;
                        Nodo der = (Nodo) g2;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        g1= (Nodo) nodo;
                }
        |<NOR>g3=G(){
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("nor");
                        Nodo izq = (Nodo) g1;
                        Nodo der = (Nodo) g3;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        g1= (Nodo) nodo;
                 }
        |<XOR>g4=G(){
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("xor");
                        Nodo izq = (Nodo) g1;
                        Nodo der = (Nodo) g4;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        g1= (Nodo) nodo;
                 }
       )*
       {return g1;}
}

Nodo G():
{Nodo h1, h2, h3;}
{
    h1=H()(<AND>h2=H() {
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("and");
                        Nodo izq = (Nodo) h1;
                        Nodo der = (Nodo) h2;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        h1= (Nodo) nodo;
                       }

        |<NAND>h3=H() {
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("nand");
                        Nodo izq = (Nodo) h1;
                        Nodo der = (Nodo) h3;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        h1= (Nodo) nodo;
                      }
       )*
       {return h1;}
}

Nodo H():
{Nodo j1,j2;}
{
    j1=J(){
         Nodo nodo = (Nodo) j1;
         return nodo;
         
        }
    |<NOT> j2=J() {
                    Nodo nodo= new Nodo();
                    nodo.setEtiqueta("not");
                    Nodo n = (Nodo) j2;
                    nodo.AddHijos(j2);
                    j2 = (Nodo) nodo;
                    return j2;
                    
               }
}


Nodo J():
{Nodo e1, e2, e3, e4, e5,e6,e7,e8;}
{
    e1=E()
    (
    <IGUALACION> e2=E() {
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("==");
                        Nodo izq = (Nodo) e1;
                        Nodo der = (Nodo) e2;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        e1= (Nodo) nodo;
                     }
    |<DIFERENCIACION> e3=E(){
                                Nodo nodo = new Nodo();
                                nodo.setEtiqueta("!=");
                                Nodo izq = (Nodo) e1;
                                Nodo der = (Nodo) e3;
                                nodo.AddHijos(izq);
                                nodo.AddHijos(der);
                                e1= (Nodo) nodo;
                            }
    |<MENOR> e4=E(){
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("<");
                        Nodo izq = (Nodo) e1;
                        Nodo der = (Nodo) e4;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        e1= (Nodo) nodo;
                   }
    |<MENORIGUAL> e5=E(){   Nodo nodo = new Nodo();
                            nodo.setEtiqueta("<=");
                            Nodo izq = (Nodo) e1;
                            Nodo der = (Nodo) e5;
                            nodo.AddHijos(izq);
                            nodo.AddHijos(der);
                            e1= (Nodo) nodo;
                        }
    |<MAYOR> e6=E(){
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta(">");
                        Nodo izq = (Nodo) e1;
                        Nodo der = (Nodo) e6;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        e1= (Nodo) nodo;
                    }
    |<MAYORIGUAL> e7=E() {
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta(">=");
                        Nodo izq = (Nodo) e1;
                        Nodo der = (Nodo) e7;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        e1= (Nodo) nodo;
                         }
    |<NULO> e8=E(){
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("nulo");
                        Nodo izq = (Nodo) e1;
                        Nodo der = (Nodo) e8;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        e1= (Nodo) nodo;
                  }

    )*
    {return e1;}
}

Nodo E():
{Nodo t1, e1, e2;}
{
    t1=T()
    (
    (<MAS> e1=T(){
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("+");
                    Nodo izq = (Nodo) t1;
                    Nodo der = (Nodo) e1;
                    nodo.AddHijos(izq);
                    nodo.AddHijos(der);
                    t1= (Nodo) nodo;
                 })
    |(<MENOS> e2=T(){
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("-");
                    Nodo izq=(Nodo) t1;
                    Nodo der=(Nodo) e2;
                    nodo.AddHijos(izq);
                    nodo.AddHijos(der);
                    t1= (Nodo) nodo;
                 }
     )
    )*
    {return t1;}
}

Nodo T():
{Nodo f1, t1, t2;}
{
    f1=F()
    (
    (<POR> t1=F(){
                    Nodo nodo = new Nodo();
                    nodo.setEtiqueta("*");
                    Nodo izq=(Nodo) f1;
                    Nodo der=(Nodo) t1;
                    nodo.AddHijos(izq);
                    nodo.AddHijos(der);
                    f1= (Nodo) nodo;
              })
    |(<DIVIDIR> t2=F(){ 
                        Nodo nodo = new Nodo();
                        nodo.setEtiqueta("/");
                        Nodo izq=(Nodo) f1;
                        Nodo der=(Nodo) t2;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        f1= (Nodo) nodo;
                   })
    )*
    {return f1;}
}

Nodo F():
{Nodo l1, f1;}
{
    l1=L()
    (
    <POTENCIA> f1=L() {
                        Nodo nodo= new Nodo();
                        nodo.setEtiqueta("^");
                        Nodo izq=(Nodo) l1;
                        Nodo der=(Nodo) f1;
                        nodo.AddHijos(izq);
                        nodo.AddHijos(der);
                        l1= (Nodo) nodo;
                        
                      }
    )*
    {return l1;}
}

Nodo L():
{Token t; Nodo e1, e2, e3;}
{
    t=<ENTERO> {
                    Nodo nodo= new Nodo();
                    nodo.setEtiqueta("valor");
                    Nodo tipo= new Nodo();
                    tipo.setEtiqueta("entero");
                    nodo.AddHijos(tipo);
                    Nodo n = new Nodo();
                    n.setEtiqueta(t.image);
                    n.setCadena(t.image);
                    n.setValor(Integer.parseInt(t.image));
                    n.setColumna(t.beginColumn);
                    n.setLinea(t.beginLine);
                    tipo.AddHijos(n);
                    return nodo;
               }
    |t=<DECIMAL>{
                    Nodo nodo= new Nodo();
                    nodo.setEtiqueta("valor");
                    Nodo tipo= new Nodo();
                    tipo.setEtiqueta("decimal");
                    nodo.AddHijos(tipo);
                    Nodo n = new Nodo();
                    n.setEtiqueta(t.image);
                    n.setCadena(t.image);
                    n.setValorDecimal(Double.parseDouble(t.image));
                    n.setColumna(t.beginColumn);
                    n.setLinea(t.beginLine);
                    tipo.AddHijos(n);
                    return nodo;
                }
    |LOOKAHEAD(2) t=<ID> 
    {
                Nodo nodo= new Nodo();
                nodo.setEtiqueta("variable");
                Nodo n = new Nodo();
                n.setEtiqueta(t.image);
                n.setCadena(t.image);
                n.setColumna(t.beginColumn);
                n.setLinea(t.beginLine);
                nodo.AddHijos(n);
                return nodo;
            }
    |t=<TRUE>{
                Nodo nodo= new Nodo();
                nodo.setEtiqueta("valor");
                Nodo tipo= new Nodo();
                tipo.setEtiqueta("bool");
                nodo.AddHijos(tipo);
                Nodo n = new Nodo();
                n.setEtiqueta("verdadero");
                n.setCadena(t.image);
                n.setValor(1);
                n.setColumna(t.beginColumn);
                n.setLinea(t.beginLine);
                tipo.AddHijos(n);
                return nodo;  
             }
    |t=<FALSE>{
                Nodo nodo= new Nodo();
                nodo.setEtiqueta("valor");
                Nodo tipo= new Nodo();
                tipo.setEtiqueta("bool");
                nodo.AddHijos(tipo);
                Nodo n = new Nodo();
                n.setEtiqueta("falso");
                n.setCadena(t.image);
                n.setValor(0);
                n.setColumna(t.beginColumn);
                n.setLinea(t.beginLine);
                tipo.AddHijos(n);
                return nodo;  
             } 

    |t=<PAR_IZQ>e1=EXP()<PAR_DER>{
                                Nodo nodo=(Nodo)e1;
                                return nodo;
                               }
    |t=<LLAVE_IZQ>e2=EXP()<LLAVE_DER>{
                                    Nodo nodo=(Nodo)e2;
                                    return nodo;
                                }
    |t=<COR_IZQ>e3=EXP()<COR_DER> {
                                    Nodo nodo=(Nodo)e3;
                                    return nodo;
                                }
    |t=<CADENA> { 
                    String cadena=PantallaPrincipal.QuitarComillas(t.image);
                    int valor=PantallaPrincipal.ObtenerAscii(cadena);
                    Nodo nodo= new Nodo();
                    nodo.setEtiqueta("valor");
                    Nodo tipo= new Nodo();
                    tipo.setEtiqueta("cadena");
                    nodo.AddHijos(tipo);
                    Nodo n = new Nodo();
                    n.setEtiqueta(cadena);
                    n.setCadena(cadena);
                    n.setValor(valor);
                    n.setColumna(t.beginColumn);
                    n.setLinea(t.beginLine);
                    tipo.AddHijos(n);
                    return nodo;    
                    

    }
    |t=<CARACTER> {
                    String cadena=PantallaPrincipal.QuitarComillas(t.image);
                    int valor=PantallaPrincipal.ObtenerAscii(cadena);
                    Nodo nodo= new Nodo();
                    nodo.setEtiqueta("valor");
                    Nodo tipo= new Nodo();
                    tipo.setEtiqueta("caracter");
                    nodo.AddHijos(tipo);
                    Nodo n = new Nodo();
                    n.setEtiqueta(t.image);
                    n.setCadena(cadena);
                    n.setValor(valor);
                    n.setColumna(t.beginColumn);
                    n.setLinea(t.beginLine);
                    tipo.AddHijos(n);
                    return nodo;            
                    
                }
    |<MENOS>(t=<ENTERO>{
                       Nodo nodo= new Nodo();
                       nodo.setEtiqueta("valor");
                       Nodo tipo= new Nodo();
                       tipo.setEtiqueta("entero");
                       nodo.AddHijos(tipo);
                       Nodo n = new Nodo();
                       n.setEtiqueta("-" + t.image);
                       n.setCadena("-" + t.image);
                       n.setValor(Integer.parseInt(t.image));
                       n.setColumna(t.beginColumn);
                       n.setLinea(t.beginLine);
                       tipo.AddHijos(n);
                       return nodo;

            }
            |t=<DECIMAL>{
                       Nodo nodo= new Nodo();
                       nodo.setEtiqueta("valor");
                       Nodo tipo= new Nodo();
                       tipo.setEtiqueta("decimal");
                       nodo.AddHijos(tipo);
                       Nodo n = new Nodo();
                       n.setEtiqueta("-" + t.image);
                       n.setCadena("-" + t.image);
                       n.setValorDecimal(Double.parseDouble(t.image));
                       n.setColumna(t.beginColumn);
                       n.setLinea(t.beginLine);
                       tipo.AddHijos(n);
                       return nodo;
                      }
            )
}

Nodo LlamadaFuncion():
{}
{
    <PAR_IZQ> (Parametros_Recibidos())? <PAR_DER>
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("llamadaFuncion");
        return nodo;
    }
}

Nodo Parametros_Recibidos():
{}
{
  E() (<COR_IZQ><ENTERO><COR_DER>)? (<COMA> Parametros_Recibidos())?
    {
        Nodo nodo = new Nodo();
        nodo.setEtiqueta("parametros");
        return nodo;
    }
}