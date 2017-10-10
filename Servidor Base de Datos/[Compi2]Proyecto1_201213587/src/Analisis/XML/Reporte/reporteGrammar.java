/* reporteGrammar.java */
/* Generated By:JavaCC: Do not edit this line. reporteGrammar.java */
package Analisis.XML.Reporte;

import Funciones.XML.*;
import Static.*;
import java.util.ArrayList;

public class reporteGrammar implements reporteGrammarConstants {
  public static void main(String args[]) throws ParseException {
    reporteGrammar parser = new reporteGrammar(System.in);
    parser.S();
  }

  final public Etiqueta S() throws ParseException {Etiqueta e;
    e = HTML();
{if ("" != null) return e;}
    throw new Error("Missing return statement in function");
  }

  final public Etiqueta HTML() throws ParseException {ArrayList<Etiqueta> le = new ArrayList<Etiqueta>(); Etiqueta e;
    jj_consume_token(T_HTML_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_HEAD_IZQ:{
      e = HEAD();
le.add(e);
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    e = BODY();
    jj_consume_token(T_HTML_DER);
le.add(e);
{if ("" != null) return new Etiqueta("html", "", "", le);}
    throw new Error("Missing return statement in function");
  }

  final public Etiqueta HEAD() throws ParseException {
    jj_consume_token(T_HEAD_IZQ);
    jj_consume_token(T_HEAD_DER);
{if ("" != null) return new Etiqueta("head", "", "");}
    throw new Error("Missing return statement in function");
  }

  final public Etiqueta BODY() throws ParseException {ArrayList<Etiqueta> le = new ArrayList<Etiqueta>();
    jj_consume_token(T_BODY_IZQ);
    le = L_ETQ();
    jj_consume_token(T_BODY_DER);
{if ("" != null) return new Etiqueta("body", "", "", le);}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<Etiqueta> L_ETQ() throws ParseException {ArrayList<Etiqueta> le = new ArrayList<Etiqueta>(); Etiqueta e;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case T_H_IZQ:{
        e = H();
le.add(e);
        break;
        }
      case T_DIV_IZQ:{
        e = DIV();
le.add(e);
        break;
        }
      case T_USQL_IZQ:{
        e = USQL();
le.add(e);
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case T_DIV_IZQ:
      case T_USQL_IZQ:
      case T_H_IZQ:{
        ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
    }
{if ("" != null) return le;}
    throw new Error("Missing return statement in function");
  }

  final public Etiqueta DIV() throws ParseException {ArrayList<Etiqueta> hijos = new ArrayList<Etiqueta>();
    jj_consume_token(T_DIV_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_DIV_IZQ:
    case T_USQL_IZQ:
    case T_H_IZQ:{
      hijos = L_ETQ();
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(T_DIV_DER);
{if ("" != null) return new Etiqueta("div", "", "", hijos);}
    throw new Error("Missing return statement in function");
  }

  final public Etiqueta USQL() throws ParseException {Token t,t2;
    t2 = jj_consume_token(T_USQL_IZQ);
    t = jj_consume_token(SRC);
    jj_consume_token(T_USQL_DER);
{if ("" != null) return new Etiqueta("usql", t2.image.substring(1, t2.image.length() - 1).replace("usql","").trim(), t.image.substring(1, t.image.length() - 1));}
    throw new Error("Missing return statement in function");
  }

  final public Etiqueta H() throws ParseException {Token t;
    jj_consume_token(T_H_IZQ);
    t = jj_consume_token(SRC);
    jj_consume_token(T_H_DER);
{if ("" != null) return new Etiqueta("h1", "", t.image.substring(1, t.image.length() - 1));}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public reporteGrammarTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[4];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x4,0xe0,0xe0,0xe0,};
   }

  /** Constructor with InputStream. */
  public reporteGrammar(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public reporteGrammar(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new reporteGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public reporteGrammar(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new reporteGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public reporteGrammar(reporteGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(reporteGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[19];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 4; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 19; i++) {
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