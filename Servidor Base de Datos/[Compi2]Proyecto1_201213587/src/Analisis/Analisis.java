/* Analisis.java */
/* Generated By:JavaCC: Do not edit this line. Analisis.java */
package Analisis;

public class Analisis implements AnalisisConstants {
  public static void main(String args[]) throws ParseException {
    Analisis parser = new Analisis(System.in);
    parser.S();
  }

  final public void S() throws ParseException {
System.out.println("Comienza!!");
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_CREAR:
    case T_USAR:
    case T_ALTERAR:
    case T_ELIMINAR:
    case T_INSERTAR:
    case T_ACTUALIZAR:
    case T_BORRAR:
    case T_SELECCIONAR:
    case T_OTORGAR:
    case T_DENEGAR:
    case T_DECLARAR:
    case T_IMPRIMIR:
    case T_BACKUP_USQL:
    case T_BACKUP_COMPLETO:
    case T_RESTAURAR_USQL:
    case T_RESTAURAR_COMPLETO:
    case ID:{
      L_INSTRUCCION();
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
System.out.println("Exito!!");
  }

  final public void L_INSTRUCCION() throws ParseException {
    INSTRUCCION();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_CREAR:
    case T_USAR:
    case T_ALTERAR:
    case T_ELIMINAR:
    case T_INSERTAR:
    case T_ACTUALIZAR:
    case T_BORRAR:
    case T_SELECCIONAR:
    case T_OTORGAR:
    case T_DENEGAR:
    case T_DECLARAR:
    case T_IMPRIMIR:
    case T_BACKUP_USQL:
    case T_BACKUP_COMPLETO:
    case T_RESTAURAR_USQL:
    case T_RESTAURAR_COMPLETO:
    case ID:{
      L_INSTRUCCION();
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      ;
    }
  }

  final public void INSTRUCCION() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_CREAR:
    case T_USAR:
    case T_ALTERAR:
    case T_ELIMINAR:
    case T_BACKUP_USQL:
    case T_BACKUP_COMPLETO:
    case T_RESTAURAR_USQL:
    case T_RESTAURAR_COMPLETO:{
System.out.println("etntro llamada ddl");
      DDL();
      break;
      }
    case T_INSERTAR:
    case T_ACTUALIZAR:
    case T_BORRAR:
    case T_SELECCIONAR:{
System.out.println("etntro llamada d,ml");
      DML();
      break;
      }
    case T_OTORGAR:
    case T_DENEGAR:{
System.out.println("etntro llamada dcl");
      DCL();
      break;
      }
    case T_DECLARAR:{
System.out.println("etntro llamada decla");
      DECLARACION();
      break;
      }
    case ID:{
System.out.println("etntro llamada metodo");
      LLAMADA_METODO();
      break;
      }
    case T_IMPRIMIR:{
System.out.println("etntro llamada imprimr");
      jj_consume_token(T_IMPRIMIR);
      jj_consume_token(PAR_IZQ);
      LOGICA_OR();
      jj_consume_token(PAR_DER);
      jj_consume_token(PCOMA);
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void DDL() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_USAR:{
      jj_consume_token(T_USAR);
      jj_consume_token(ID);
      jj_consume_token(PCOMA);
      break;
      }
    case T_CREAR:{
      CREATE();
      break;
      }
    case T_ALTERAR:{
      ALTER();
      break;
      }
    case T_ELIMINAR:{
      ELIMINAR();
      break;
      }
    case T_BACKUP_USQL:
    case T_BACKUP_COMPLETO:{
      BACKUP();
      break;
      }
    case T_RESTAURAR_USQL:
    case T_RESTAURAR_COMPLETO:{
      RESTAURAR();
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void DML() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_INSERTAR:{
      INSERTAR();
      break;
      }
    case T_ACTUALIZAR:{
      ACTUALIZAR();
      break;
      }
    case T_BORRAR:{
      BORRAR();
      break;
      }
    case T_SELECCIONAR:{
      SELECCIONAR();
      jj_consume_token(PCOMA);
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void DCL() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_OTORGAR:{
      jj_consume_token(T_OTORGAR);
      L_ID();
      jj_consume_token(ID);
      jj_consume_token(PUNTO);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case POR:{
        jj_consume_token(POR);
        break;
        }
      case ID:{
        jj_consume_token(ID);
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(PCOMA);
      break;
      }
    case T_DENEGAR:{
      jj_consume_token(T_DENEGAR);
      L_ID();
      jj_consume_token(ID);
      jj_consume_token(PUNTO);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case POR:{
        jj_consume_token(POR);
        break;
        }
      case ID:{
        jj_consume_token(ID);
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(PCOMA);
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void SSL() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_DECLARAR:{
      DECLARACION();
      break;
      }
    case ARROBA:{
      ASIGNACION();
      break;
      }
    case T_SI:{
      SI();
      break;
      }
    case T_SELECCIONA:{
      SELECCIONA();
      break;
      }
    case T_PARA:{
      PARA();
      break;
      }
    case T_MIENTRAS:{
      MIENTRAS();
      break;
      }
    case T_DETENER:{
      jj_consume_token(T_DETENER);
      jj_consume_token(PCOMA);
      break;
      }
    case T_IMPRIMIR:{
      jj_consume_token(T_IMPRIMIR);
      jj_consume_token(PAR_IZQ);
      LOGICA_OR();
      jj_consume_token(PAR_DER);
      jj_consume_token(PCOMA);
      break;
      }
    case T_RETORNO:{
      RETORNO();
      jj_consume_token(PCOMA);
      break;
      }
    case ID:{
      LLAMADA_METODO();
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void LLAMADA_METODO() throws ParseException {
    jj_consume_token(ID);
    jj_consume_token(PAR_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NOT:
    case T_FECHA:
    case T_FECHA_HORA:
    case T_CONTAR:
    case CADENA:
    case ENTERO:
    case DECIMAL:
    case ID:
    case ARROBA:{
      L_EXPRESIONES();
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    jj_consume_token(PAR_DER);
    jj_consume_token(PCOMA);
  }

  final public void CREATE() throws ParseException {
    jj_consume_token(T_CREAR);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_BASE_DATOS:
    case T_TABLA:
    case T_OBJETO:
    case T_USUARIO:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case T_BASE_DATOS:{
        CREATE_BASE();
        break;
        }
      case T_TABLA:{
        CREATE_TABLA();
        break;
        }
      case T_OBJETO:{
        CREATE_OBJETO();
        break;
        }
      case T_USUARIO:{
        CREATE_USUARIO();
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(PCOMA);
      break;
      }
    case T_PROCEDIMIENTO:{
      CREATE_PROCEDIMIENTO();
      break;
      }
    case T_FUNCION:{
      CREATE_FUNCION();
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void CREATE_BASE() throws ParseException {
    jj_consume_token(T_BASE_DATOS);
    jj_consume_token(ID);
  }

  final public void CREATE_TABLA() throws ParseException {
    jj_consume_token(T_TABLA);
    jj_consume_token(ID);
    jj_consume_token(PAR_IZQ);
    L_CAMPO();
    jj_consume_token(PAR_DER);
  }

  final public void L_CAMPO() throws ParseException {
    CAMPO();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case COMA:{
      jj_consume_token(COMA);
      L_CAMPO();
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      ;
    }
  }

  final public void CAMPO() throws ParseException {
    TIPO_DATO();
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_NULO:
    case T_NO_NULO:
    case T_AUTOINCREMETABLE:
    case T_LLAVE_PRIMARIA:
    case T_LLAVE_FORANEA:{
      L_COMPLEMENTO();
      break;
      }
    default:
      jj_la1[13] = jj_gen;
      ;
    }
  }

  final public void TIPO_DATO() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TEXT:{
      jj_consume_token(T_TEXT);
      break;
      }
    case T_INTEGER:{
      jj_consume_token(T_INTEGER);
      break;
      }
    case T_DOUBLE:{
      jj_consume_token(T_DOUBLE);
      break;
      }
    case T_BOOL:{
      jj_consume_token(T_BOOL);
      break;
      }
    case T_DATE:{
      jj_consume_token(T_DATE);
      break;
      }
    case T_DATETIME:{
      jj_consume_token(T_DATETIME);
      break;
      }
    case ID:{
      jj_consume_token(ID);
      break;
      }
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void L_COMPLEMENTO() throws ParseException {
    COMPLEMENTO();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_NULO:
    case T_NO_NULO:
    case T_AUTOINCREMETABLE:
    case T_LLAVE_PRIMARIA:
    case T_LLAVE_FORANEA:{
      L_COMPLEMENTO();
      break;
      }
    default:
      jj_la1[15] = jj_gen;
      ;
    }
  }

  final public void COMPLEMENTO() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_NULO:{
      jj_consume_token(T_NULO);
      break;
      }
    case T_NO_NULO:{
      jj_consume_token(T_NO_NULO);
      break;
      }
    case T_AUTOINCREMETABLE:{
      jj_consume_token(T_AUTOINCREMETABLE);
      break;
      }
    case T_LLAVE_PRIMARIA:{
      jj_consume_token(T_LLAVE_PRIMARIA);
      break;
      }
    case T_LLAVE_FORANEA:{
      jj_consume_token(T_LLAVE_FORANEA);
      jj_consume_token(ID);
      break;
      }
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void CREATE_OBJETO() throws ParseException {
    jj_consume_token(T_OBJETO);
    jj_consume_token(ID);
    jj_consume_token(PAR_IZQ);
    L_ATRIBUTO();
    jj_consume_token(PAR_DER);
  }

  final public void L_ATRIBUTO() throws ParseException {
    ATRIBUTO();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case COMA:{
      jj_consume_token(COMA);
      L_ATRIBUTO();
      break;
      }
    default:
      jj_la1[17] = jj_gen;
      ;
    }
  }

  final public void ATRIBUTO() throws ParseException {
    TIPO_DATO_ATRIBUTO();
    jj_consume_token(ID);
  }

  final public void TIPO_DATO_ATRIBUTO() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TEXT:{
      jj_consume_token(T_TEXT);
      break;
      }
    case T_INTEGER:{
      jj_consume_token(T_INTEGER);
      break;
      }
    case T_DOUBLE:{
      jj_consume_token(T_DOUBLE);
      break;
      }
    case T_BOOL:{
      jj_consume_token(T_BOOL);
      break;
      }
    case T_DATE:{
      jj_consume_token(T_DATE);
      break;
      }
    case T_DATETIME:{
      jj_consume_token(T_DATETIME);
      break;
      }
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void CREATE_PROCEDIMIENTO() throws ParseException {
    jj_consume_token(T_PROCEDIMIENTO);
    jj_consume_token(ID);
    jj_consume_token(PAR_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TEXT:
    case T_INTEGER:
    case T_DOUBLE:
    case T_BOOL:
    case T_DATE:
    case T_DATETIME:
    case ID:{
      L_PARAMETRO();
      break;
      }
    default:
      jj_la1[19] = jj_gen;
      ;
    }
    jj_consume_token(PAR_DER);
    jj_consume_token(LLAVE_IZQ);
    L_SENTENCIAS();
    jj_consume_token(LLAVE_DER);
  }

  final public void L_PARAMETRO() throws ParseException {
    PARAMETRO();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case COMA:{
      jj_consume_token(COMA);
      L_PARAMETRO();
      break;
      }
    default:
      jj_la1[20] = jj_gen;
      ;
    }
  }

  final public void PARAMETRO() throws ParseException {
    TIPO_DATO();
    jj_consume_token(ARROBA);
  }

  final public void CREATE_FUNCION() throws ParseException {
    jj_consume_token(T_FUNCION);
    jj_consume_token(ID);
    jj_consume_token(PAR_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TEXT:
    case T_INTEGER:
    case T_DOUBLE:
    case T_BOOL:
    case T_DATE:
    case T_DATETIME:
    case ID:{
      L_PARAMETRO();
      break;
      }
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    jj_consume_token(PAR_DER);
    TIPO_DATO();
    jj_consume_token(LLAVE_IZQ);
    L_SENTENCIAS();
    jj_consume_token(LLAVE_DER);
  }

  final public void CREATE_USUARIO() throws ParseException {
    jj_consume_token(T_USUARIO);
    jj_consume_token(ID);
    jj_consume_token(T_COLOCAR);
    jj_consume_token(T_PASSWORD);
    jj_consume_token(IGUAL);
    jj_consume_token(CADENA);
  }

  final public void RETORNO() throws ParseException {
    jj_consume_token(T_RETORNO);
    LOGICA_OR();
  }

  final public void ALTER() throws ParseException {
    jj_consume_token(T_ALTERAR);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TABLA:{
      ALTER_TABLA();
      break;
      }
    case T_OBJETO:{
      ALTER_OBJETO();
      break;
      }
    case T_USUARIO:{
      ALTER_USUARIO();
      break;
      }
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(PCOMA);
  }

  final public void ALTER_TABLA() throws ParseException {
    jj_consume_token(T_TABLA);
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_AGREGAR:{
      jj_consume_token(T_AGREGAR);
      jj_consume_token(PAR_IZQ);
      L_CAMPO();
      jj_consume_token(PAR_DER);
      break;
      }
    case T_QUITAR:{
      jj_consume_token(T_QUITAR);
      L_ID();
      break;
      }
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void L_ID() throws ParseException {
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case COMA:{
      jj_consume_token(COMA);
      L_ID();
      break;
      }
    default:
      jj_la1[24] = jj_gen;
      ;
    }
  }

  final public void ALTER_OBJETO() throws ParseException {
    jj_consume_token(T_OBJETO);
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_AGREGAR:{
      jj_consume_token(T_AGREGAR);
      jj_consume_token(PAR_IZQ);
      L_ATRIBUTO();
      jj_consume_token(PAR_DER);
      break;
      }
    case T_QUITAR:{
      jj_consume_token(T_QUITAR);
      L_ID();
      break;
      }
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ALTER_USUARIO() throws ParseException {
    jj_consume_token(T_USUARIO);
    jj_consume_token(ID);
    jj_consume_token(T_CAMBIAR);
    jj_consume_token(T_PASSWORD);
    jj_consume_token(IGUAL);
    jj_consume_token(CADENA);
  }

  final public void ELIMINAR() throws ParseException {
    jj_consume_token(T_ELIMINAR);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TABLA:{
      jj_consume_token(T_TABLA);
      break;
      }
    case T_BASE_DATOS:{
      jj_consume_token(T_BASE_DATOS);
      break;
      }
    case T_OBJETO:{
      jj_consume_token(T_OBJETO);
      break;
      }
    case T_USUARIO:{
      jj_consume_token(T_USUARIO);
      break;
      }
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(ID);
    jj_consume_token(PCOMA);
  }

  final public void INSERTAR() throws ParseException {
    jj_consume_token(T_INSERTAR);
    jj_consume_token(T_TABLA);
    jj_consume_token(ID);
    jj_consume_token(PAR_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ID:{
      L_ID();
      jj_consume_token(PAR_DER);
      jj_consume_token(T_VALORES);
      jj_consume_token(PAR_IZQ);
      break;
      }
    default:
      jj_la1[27] = jj_gen;
      ;
    }
    L_EXPRESIONES();
    jj_consume_token(PAR_DER);
    jj_consume_token(PCOMA);
  }

  final public void ACTUALIZAR() throws ParseException {
    jj_consume_token(T_ACTUALIZAR);
    jj_consume_token(T_TABLA);
    jj_consume_token(ID);
    jj_consume_token(PAR_IZQ);
    L_ID();
    jj_consume_token(PAR_DER);
    jj_consume_token(T_VALORES);
    jj_consume_token(PAR_IZQ);
    L_EXPRESIONES();
    jj_consume_token(PAR_DER);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_DONDE:{
      jj_consume_token(T_DONDE);
      LOGICA_OR();
      break;
      }
    default:
      jj_la1[28] = jj_gen;
      ;
    }
    jj_consume_token(PCOMA);
  }

  final public void BORRAR() throws ParseException {
    jj_consume_token(T_BORRAR);
    jj_consume_token(T_TABLA);
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_DONDE:{
      jj_consume_token(T_DONDE);
      LOGICA_OR();
      break;
      }
    default:
      jj_la1[29] = jj_gen;
      ;
    }
    jj_consume_token(PCOMA);
  }

  final public void SELECCIONAR() throws ParseException {
    jj_consume_token(T_SELECCIONAR);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ID:{
      L_ID();
      break;
      }
    case POR:{
      jj_consume_token(POR);
      break;
      }
    default:
      jj_la1[30] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(T_DE);
    L_ID();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_DONDE:{
      jj_consume_token(T_DONDE);
      LOGICA_OR();
      break;
      }
    default:
      jj_la1[31] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_ORDENAR:{
      jj_consume_token(T_ORDENAR);
      jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case T_ASC:{
        jj_consume_token(T_ASC);
        break;
        }
      case T_DESC:{
        jj_consume_token(T_DESC);
        break;
        }
      default:
        jj_la1[32] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[33] = jj_gen;
      ;
    }
  }

  final public void L_SENTENCIAS() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_RETORNO:
    case T_INSERTAR:
    case T_ACTUALIZAR:
    case T_BORRAR:
    case T_SELECCIONAR:
    case T_OTORGAR:
    case T_DENEGAR:
    case T_DECLARAR:
    case T_SI:
    case T_SELECCIONA:
    case T_PARA:
    case T_MIENTRAS:
    case T_DETENER:
    case T_IMPRIMIR:
    case ID:
    case ARROBA:{
      L_SENTENCIA();
      break;
      }
    default:
      jj_la1[34] = jj_gen;
      ;
    }
  }

  final public void L_SENTENCIA() throws ParseException {
    SENTENCIA();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_RETORNO:
    case T_INSERTAR:
    case T_ACTUALIZAR:
    case T_BORRAR:
    case T_SELECCIONAR:
    case T_OTORGAR:
    case T_DENEGAR:
    case T_DECLARAR:
    case T_SI:
    case T_SELECCIONA:
    case T_PARA:
    case T_MIENTRAS:
    case T_DETENER:
    case T_IMPRIMIR:
    case ID:
    case ARROBA:{
      L_SENTENCIA();
      break;
      }
    default:
      jj_la1[35] = jj_gen;
      ;
    }
  }

  final public void SENTENCIA() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_RETORNO:
    case T_DECLARAR:
    case T_SI:
    case T_SELECCIONA:
    case T_PARA:
    case T_MIENTRAS:
    case T_DETENER:
    case T_IMPRIMIR:
    case ID:
    case ARROBA:{
      SSL();
      break;
      }
    case T_INSERTAR:
    case T_ACTUALIZAR:
    case T_BORRAR:
    case T_SELECCIONAR:{
      DML();
      break;
      }
    case T_OTORGAR:
    case T_DENEGAR:{
      DCL();
      break;
      }
    default:
      jj_la1[36] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void DECLARACION() throws ParseException {
    jj_consume_token(T_DECLARAR);
    L_VARIABLE();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TEXT:
    case T_INTEGER:
    case T_DOUBLE:
    case T_BOOL:
    case T_DATE:
    case T_DATETIME:{
      TIPO_DATO_ATRIBUTO();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IGUAL:{
        jj_consume_token(IGUAL);
        LOGICA_OR();
        break;
        }
      default:
        jj_la1[37] = jj_gen;
        ;
      }
      break;
      }
    case ID:{
      jj_consume_token(ID);
      break;
      }
    default:
      jj_la1[38] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(PCOMA);
  }

  final public void L_VARIABLE() throws ParseException {
    jj_consume_token(ARROBA);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case COMA:{
      jj_consume_token(COMA);
      L_VARIABLE();
      break;
      }
    default:
      jj_la1[39] = jj_gen;
      ;
    }
  }

  final public void ASIGNACION() throws ParseException {
    jj_consume_token(ARROBA);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case PUNTO:{
      jj_consume_token(PUNTO);
      jj_consume_token(ID);
      break;
      }
    default:
      jj_la1[40] = jj_gen;
      ;
    }
    jj_consume_token(IGUAL);
    LOGICA_OR();
    jj_consume_token(PCOMA);
  }

  final public void SI() throws ParseException {
    jj_consume_token(T_SI);
    jj_consume_token(PAR_IZQ);
    LOGICA_OR();
    jj_consume_token(PAR_DER);
    jj_consume_token(LLAVE_IZQ);
    L_SENTENCIAS();
    jj_consume_token(LLAVE_DER);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_SINO:{
      jj_consume_token(T_SINO);
      jj_consume_token(LLAVE_IZQ);
      L_SENTENCIAS();
      jj_consume_token(LLAVE_DER);
      break;
      }
    default:
      jj_la1[41] = jj_gen;
      ;
    }
  }

  final public void SELECCIONA() throws ParseException {
    jj_consume_token(T_SELECCIONA);
    jj_consume_token(PAR_IZQ);
    LOGICA_OR();
    jj_consume_token(PAR_DER);
    jj_consume_token(LLAVE_IZQ);
    L_CASOS();
    jj_consume_token(LLAVE_DER);
  }

  final public void L_CASOS() throws ParseException {
    jj_consume_token(T_CASO);
    VALOR_CASO();
    jj_consume_token(DOSP);
    L_SENTENCIAS();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_CASO:{
      L_CASOS();
      break;
      }
    default:
      jj_la1[42] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_DEFECTO:{
      DEFECTO();
      break;
      }
    default:
      jj_la1[43] = jj_gen;
      ;
    }
  }

  final public void VALOR_CASO() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CADENA:{
      jj_consume_token(CADENA);
      break;
      }
    case ENTERO:{
      jj_consume_token(ENTERO);
      break;
      }
    case DECIMAL:{
      jj_consume_token(DECIMAL);
      break;
      }
    default:
      jj_la1[44] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void DEFECTO() throws ParseException {
    jj_consume_token(T_DEFECTO);
    jj_consume_token(DOSP);
    L_SENTENCIAS();
  }

  final public void PARA() throws ParseException {
    jj_consume_token(T_PARA);
    jj_consume_token(PAR_IZQ);
    DECLARACION_PARA();
    jj_consume_token(PCOMA);
    LOGICA_OR();
    jj_consume_token(PCOMA);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case AUMENTO:{
      jj_consume_token(AUMENTO);
      break;
      }
    case DECREMENTO:{
      jj_consume_token(DECREMENTO);
      break;
      }
    default:
      jj_la1[45] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(PAR_DER);
    jj_consume_token(LLAVE_IZQ);
    L_SENTENCIAS();
    jj_consume_token(LLAVE_DER);
  }

  final public void DECLARACION_PARA() throws ParseException {
    jj_consume_token(T_DECLARAR);
    jj_consume_token(ARROBA);
    jj_consume_token(T_INTEGER);
    jj_consume_token(IGUAL);
    LOGICA_OR();
  }

  final public void MIENTRAS() throws ParseException {
    jj_consume_token(T_MIENTRAS);
    jj_consume_token(PAR_IZQ);
    LOGICA_OR();
    jj_consume_token(PAR_DER);
    jj_consume_token(LLAVE_IZQ);
    L_SENTENCIAS();
    jj_consume_token(LLAVE_DER);
  }

  final public void BACKUP() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_BACKUP_USQL:{
      jj_consume_token(T_BACKUP_USQL);
      break;
      }
    case T_BACKUP_COMPLETO:{
      jj_consume_token(T_BACKUP_COMPLETO);
      break;
      }
    default:
      jj_la1[46] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(ID);
    jj_consume_token(ID);
    jj_consume_token(PCOMA);
  }

  final public void RESTAURAR() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_RESTAURAR_USQL:{
      jj_consume_token(T_RESTAURAR_USQL);
      break;
      }
    case T_RESTAURAR_COMPLETO:{
      jj_consume_token(T_RESTAURAR_COMPLETO);
      break;
      }
    default:
      jj_la1[47] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(CADENA);
    jj_consume_token(PCOMA);
  }

  final public void FUNCINES_NATIVAS_VALOR() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_FECHA:{
      jj_consume_token(T_FECHA);
      jj_consume_token(PAR_IZQ);
      jj_consume_token(PAR_DER);
      break;
      }
    case T_FECHA_HORA:{
      jj_consume_token(T_FECHA_HORA);
      jj_consume_token(PAR_IZQ);
      jj_consume_token(PAR_DER);
      break;
      }
    case T_CONTAR:{
      jj_consume_token(T_CONTAR);
      jj_consume_token(PAR_IZQ);
      jj_consume_token(FLECHA_IZQ);
      SELECCIONAR();
      jj_consume_token(FLECHA_DER);
      jj_consume_token(PAR_DER);
      break;
      }
    default:
      jj_la1[48] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void LLAMADA_OBJETO() throws ParseException {
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case PAR_IZQ:
    case PUNTO:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PAR_IZQ:{
        jj_consume_token(PAR_IZQ);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case NOT:
        case T_FECHA:
        case T_FECHA_HORA:
        case T_CONTAR:
        case CADENA:
        case ENTERO:
        case DECIMAL:
        case ID:
        case ARROBA:{
          L_EXPRESIONES();
          break;
          }
        default:
          jj_la1[49] = jj_gen;
          ;
        }
        jj_consume_token(PAR_DER);
        break;
        }
      case PUNTO:{
        jj_consume_token(PUNTO);
        jj_consume_token(ID);
        break;
        }
      default:
        jj_la1[50] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[51] = jj_gen;
      ;
    }
  }

  final public void L_EXPRESIONES() throws ParseException {
    LOGICA_OR();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case COMA:{
      jj_consume_token(COMA);
      L_EXPRESIONES();
      break;
      }
    default:
      jj_la1[52] = jj_gen;
      ;
    }
  }

  final public void LOGICA_OR() throws ParseException {
    LOGICA_AND();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case OR:{
      jj_consume_token(OR);
      LOGICA_OR();
      break;
      }
    default:
      jj_la1[53] = jj_gen;
      ;
    }
  }

  final public void LOGICA_AND() throws ParseException {
    LOGICA_NOT();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case AND:{
      jj_consume_token(AND);
      LOGICA_AND();
      break;
      }
    default:
      jj_la1[54] = jj_gen;
      ;
    }
  }

  final public void LOGICA_NOT() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NOT:{
      jj_consume_token(NOT);
      break;
      }
    default:
      jj_la1[55] = jj_gen;
      ;
    }
    RELACIONAL();
  }

  final public void RELACIONAL() throws ParseException {
    E();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IGUALACION:
    case DIFERENCIACION:
    case MENOR:
    case MAYOR:
    case MENORIGUAL:
    case MAYORIGUAL:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IGUALACION:{
        jj_consume_token(IGUALACION);
        break;
        }
      case DIFERENCIACION:{
        jj_consume_token(DIFERENCIACION);
        break;
        }
      case MAYOR:{
        jj_consume_token(MAYOR);
        break;
        }
      case MENOR:{
        jj_consume_token(MENOR);
        break;
        }
      case MAYORIGUAL:{
        jj_consume_token(MAYORIGUAL);
        break;
        }
      case MENORIGUAL:{
        jj_consume_token(MENORIGUAL);
        break;
        }
      default:
        jj_la1[56] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      RELACIONAL();
      break;
      }
    default:
      jj_la1[57] = jj_gen;
      ;
    }
  }

  final public void E() throws ParseException {
    T();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case MAS:
    case MENOS:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MAS:{
        jj_consume_token(MAS);
        E();
        break;
        }
      case MENOS:{
        jj_consume_token(MENOS);
        E();
        break;
        }
      default:
        jj_la1[58] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[59] = jj_gen;
      ;
    }
  }

  final public void T() throws ParseException {
    G();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case POR:
    case DIVISION:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case POR:{
        jj_consume_token(POR);
        T();
        break;
        }
      case DIVISION:{
        jj_consume_token(DIVISION);
        T();
        break;
        }
      default:
        jj_la1[60] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[61] = jj_gen;
      ;
    }
  }

  final public void G() throws ParseException {
    H();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case POTENCIA:{
      jj_consume_token(POTENCIA);
      G();
      break;
      }
    default:
      jj_la1[62] = jj_gen;
      ;
    }
  }

  final public void H() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CADENA:{
      jj_consume_token(CADENA);
      break;
      }
    case ENTERO:{
      jj_consume_token(ENTERO);
      break;
      }
    case DECIMAL:{
      jj_consume_token(DECIMAL);
      break;
      }
    case ARROBA:{
      jj_consume_token(ARROBA);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PUNTO:{
        jj_consume_token(PUNTO);
        jj_consume_token(ID);
        break;
        }
      default:
        jj_la1[63] = jj_gen;
        ;
      }
      break;
      }
    case ID:{
      LLAMADA_OBJETO();
      break;
      }
    case T_FECHA:
    case T_FECHA_HORA:
    case T_CONTAR:{
      FUNCINES_NATIVAS_VALOR();
      break;
      }
    default:
      jj_la1[64] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public AnalisisTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[65];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static private int[] jj_la1_3;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
      jj_la1_init_3();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x0,0x0,0x0,0x8,0x8,0x0,0x0,0x20000000,0x0,0x0,0x8000,0x0,0xc0000000,0x0,0x0,0x8000,0xc0000000,0xc0000000,0x8000,0xc0000000,0x0,0x0,0x8000,0x0,0x0,0x0,0x0,0x0,0x8,0x0,0x0,0x0,0x0,0x0,0x0,0x20000,0xc0000000,0x8000,0x40000,0x0,0x0,0x0,0x0,0xc0,0x0,0x0,0x0,0x20000000,0x40100,0x40100,0x8000,0x10000000,0x8000000,0x20000000,0x7e00000,0x7e00000,0x6,0x6,0x18,0x18,0x20,0x40000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x6b180010,0x6b180010,0x6b180010,0x1180010,0x6a000000,0x0,0x0,0x0,0x8000,0x0,0x11060,0x17060,0x0,0xf80,0xf,0xf80,0xf80,0x0,0xf,0xf,0x0,0xf,0x11040,0x600000,0x0,0x600000,0x11060,0x0,0x10000000,0x10000000,0x0,0x10000000,0x0,0x0,0x6a008000,0x6a008000,0x6a008000,0x0,0xf,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x43c4038,0x43c4038,0x43c4038,0x3c0000,0x0,0x4000000,0x4000000,0x18,0xc007960,0xec38000,0x0,0x0,0x0,0x0,0x4000000,0x0,0x0,0x0,0x0,0x4000000,0x0,0x4000000,0x0,0x0,0x0,0x0,0x0,0x4000000,0x0,0x0,0x4000000,0x0,0x6,0x1,0xc007978,0xc007978,0xc007978,0x0,0x4000000,0x0,0x0,0x80,0x200,0x400,0x2c00000,0x0,0xc0000,0x300000,0x38000,0xec38000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xec38000,};
   }
   private static void jj_la1_init_3() {
      jj_la1_3 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public Analisis(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Analisis(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AnalisisTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Analisis(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalisisTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Analisis(AnalisisTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(AnalisisTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[98];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 65; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
          if ((jj_la1_3[i] & (1<<j)) != 0) {
            la1tokens[96+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 98; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
