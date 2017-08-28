/* funcGrammar.java */
/* Generated By:JavaCC: Do not edit this line. funcGrammar.java */
package Analisis.XML.Funcion;

import Funciones.XML.*;
import Static.*;
import java.util.ArrayList;

public class funcGrammar implements funcGrammarConstants {
  public static void main(String args[]) throws ParseException {
    funcGrammar parser = new funcGrammar(System.in);
    parser.S();
  }

  final public ArrayList<Funcion> S() throws ParseException {ArrayList<Funcion> f = new ArrayList<Funcion>();
System.out.println("Comienza!!");
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_FUNC_IZQ:{
      f = L_FUNC();
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
{if ("" != null) return f;}
System.out.println("Exito!!");
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<Funcion> L_FUNC() throws ParseException {ArrayList<Funcion> f = new ArrayList<Funcion>(); ArrayList<Funcion> f2 = new ArrayList<Funcion>();
    f = FUNC();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_FUNC_IZQ:{
      f2 = L_FUNC();
for(int i=0; i < f2.size(); i++){
                        f.add(f2.get(i));
                    }
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      ;
    }
{if ("" != null) return f;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<Funcion> FUNC() throws ParseException {String t, n,s; ArrayList<Parametro> p = new ArrayList<Parametro>();
    jj_consume_token(T_FUNC_IZQ);
    t = TIPO();
    n = NOMBRE();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_PARAMS_IZQ:{
      jj_consume_token(T_PARAMS_IZQ);
      p = L_PARAMS();
      jj_consume_token(T_PARAMS_DER);
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    s = SRC();
    jj_consume_token(T_FUNC_DER);
ArrayList<Funcion> fun = new ArrayList<Funcion>();
        fun.add(new Funcion(t, n, s, p));
        {if ("" != null) return fun;}
    throw new Error("Missing return statement in function");
  }

  final public String TIPO() throws ParseException {String t; Token a;
    jj_consume_token(T_TIPO_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TEXT:{
      jj_consume_token(T_TEXT);
t=Tools.ttext;
      break;
      }
    case T_INTEGER:{
      jj_consume_token(T_INTEGER);
t=Tools.tinteger;
      break;
      }
    case T_DOUBLE:{
      jj_consume_token(T_DOUBLE);
t=Tools.tdouble;
      break;
      }
    case T_BOOL:{
      jj_consume_token(T_BOOL);
t=Tools.tbool;
      break;
      }
    case T_DATE:{
      jj_consume_token(T_DATE);
t=Tools.tdate;
      break;
      }
    case T_DATETIME:{
      jj_consume_token(T_DATETIME);
t=Tools.tdatetime;
      break;
      }
    case ID:{
      a = jj_consume_token(ID);
t=a.image;
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(T_TIPO_DER);
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
  }

  final public String NOMBRE() throws ParseException {Token t;
    jj_consume_token(T_NOMBRE_IZQ);
    t = jj_consume_token(CADENA);
    jj_consume_token(T_NOMBRE_DER);
{if ("" != null) return t.image.substring(1, t.image.length() - 1);}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<Parametro> L_PARAMS() throws ParseException {ArrayList<Parametro> p = new ArrayList<Parametro>(); ArrayList<Parametro> p2 = new ArrayList<Parametro>();
    p = PARAMS();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TEXT_IZQ:
    case T_INTEGER_IZQ:
    case T_DOUBLE_IZQ:
    case T_BOOL_IZQ:
    case T_DATE_IZQ:
    case T_DATETIME_IZQ:
    case ID_IZQ:{
      p2 = L_PARAMS();
for(int i=0; i < p2.size(); i++){
                        p.add(p2.get(i));
                    }
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      ;
    }
{if ("" != null) return p;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<Parametro> PARAMS() throws ParseException {ArrayList<Parametro> p = new ArrayList<Parametro>(); Token c,t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TEXT_IZQ:{
      jj_consume_token(T_TEXT_IZQ);
      c = jj_consume_token(CADENA);
p.add(new Parametro(Tools.ttext, c.image.substring(1, c.image.length() - 1)));
      jj_consume_token(T_TEXT_DER);
      break;
      }
    case T_INTEGER_IZQ:{
      jj_consume_token(T_INTEGER_IZQ);
      c = jj_consume_token(CADENA);
p.add(new Parametro(Tools.tinteger, c.image.substring(1, c.image.length() - 1)));
      jj_consume_token(T_INTEGER_DER);
      break;
      }
    case T_DOUBLE_IZQ:{
      jj_consume_token(T_DOUBLE_IZQ);
      c = jj_consume_token(CADENA);
p.add(new Parametro(Tools.tdouble, c.image.substring(1, c.image.length() - 1)));
      jj_consume_token(T_DOUBLE_DER);
      break;
      }
    case T_BOOL_IZQ:{
      jj_consume_token(T_BOOL_IZQ);
      c = jj_consume_token(CADENA);
p.add(new Parametro(Tools.tbool, c.image.substring(1, c.image.length() - 1)));
      jj_consume_token(T_BOOL_DER);
      break;
      }
    case T_DATE_IZQ:{
      jj_consume_token(T_DATE_IZQ);
      c = jj_consume_token(CADENA);
p.add(new Parametro(Tools.tdate, c.image.substring(1, c.image.length() - 1)));
      jj_consume_token(T_DATE_DER);
      break;
      }
    case T_DATETIME_IZQ:{
      jj_consume_token(T_DATETIME_IZQ);
      c = jj_consume_token(CADENA);
p.add(new Parametro(Tools.tdatetime, c.image.substring(1, c.image.length() - 1)));
      jj_consume_token(T_DATETIME_DER);
      break;
      }
    case ID_IZQ:{
      t = jj_consume_token(ID_IZQ);
      c = jj_consume_token(CADENA);
p.add(new Parametro(Tools.tobjeto, c.image.substring(1, c.image.length() - 1), t.image.substring(1, t.image.length() - 1).trim()));
      jj_consume_token(ID_DER);
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return p;}
    throw new Error("Missing return statement in function");
  }

  final public String SRC() throws ParseException {Token t;
    jj_consume_token(T_SRC_IZQ);
    t = jj_consume_token(SRC);
    jj_consume_token(T_SRC_DER);
{if ("" != null) return t.image.substring(1, t.image.length() - 1);}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public funcGrammarTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[6];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2,0x2,0x8,0x1f800000,0x8001f800,0x8001f800,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x2,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public funcGrammar(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public funcGrammar(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new funcGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public funcGrammar(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new funcGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public funcGrammar(funcGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(funcGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[38];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 6; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 38; i++) {
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