/* usrGrammar.java */
/* Generated By:JavaCC: Do not edit this line. usrGrammar.java */
package Analisis.XML.Usuario;
import java.util.ArrayList;
import Funciones.XML.Usr.*;


public class usrGrammar implements usrGrammarConstants {
  public static void main(String args[]) throws ParseException {
    usrGrammar parser = new usrGrammar(System.in);
    parser.S();
  }

  final public ArrayList<usr> S() throws ParseException {ArrayList<usr> us = new ArrayList<usr>();
System.out.println("Comienza!!");
    us = L_USR();
{if ("" != null) return us;}
System.out.println("Exito!!");
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<usr> L_USR() throws ParseException {ArrayList<usr> us = new ArrayList<usr>(); ArrayList<usr> us2 = new ArrayList<usr>();
    us = USR();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_USR_IZQ:{
      us2 = L_USR();
for(int i=0; i < us2.size(); i++){
                        us.add(us2.get(i));
                    }
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
{if ("" != null) return us;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<usr> USR() throws ParseException {String n,p,s; int t,e; ArrayList<permisosUsr> pu = new ArrayList<permisosUsr>();
    jj_consume_token(T_USR_IZQ);
    n = NOMBRE();
    p = PASS();
    t = TIPO();
    e = ESTADO();
    s = SESION();
    pu = PERMISOS();
    jj_consume_token(T_USR_DER);
ArrayList<usr> u = new ArrayList<usr>();
                        u.add(new usr(n, p, t, e, s, pu));
                        {if ("" != null) return u;}
    throw new Error("Missing return statement in function");
  }

  final public String NOMBRE() throws ParseException {Token n;
    jj_consume_token(T_NOMBRE_IZQ);
    n = jj_consume_token(ID);
    jj_consume_token(T_NOMBRE_DER);
{if ("" != null) return n.image;}
    throw new Error("Missing return statement in function");
  }

  final public String PASS() throws ParseException {Token p;
    jj_consume_token(T_PASS_IZQ);
    p = jj_consume_token(CADENA);
    jj_consume_token(T_PASS_DER);
{if ("" != null) return p.image;}
    throw new Error("Missing return statement in function");
  }

  final public int TIPO() throws ParseException {int t;
    jj_consume_token(T_TIPO_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_CERO:{
      jj_consume_token(T_CERO);
t=0;
      break;
      }
    case T_UNO:{
      jj_consume_token(T_UNO);
t=1;
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(T_TIPO_DER);
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
  }

  final public int ESTADO() throws ParseException {int e;
    jj_consume_token(T_ESTADO_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_UNO:{
      jj_consume_token(T_UNO);
e=1;
      break;
      }
    case T_CERO:{
      jj_consume_token(T_CERO);
e=0;
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(T_ESTADO_DER);
{if ("" != null) return e;}
    throw new Error("Missing return statement in function");
  }

  final public String SESION() throws ParseException {Token s;
    jj_consume_token(T_SESION_IZQ);
    s = jj_consume_token(CADENA);
    jj_consume_token(T_SESION_DER);
{if ("" != null) return s.image;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<permisosUsr> PERMISOS() throws ParseException {ArrayList<permisosUsr> lu = new ArrayList<permisosUsr>();
    jj_consume_token(T_PERMISOS_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_DB_IZQ:{
      lu = L_DB();
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(T_PERMISOS_DER);
{if ("" != null) return lu;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<permisosUsr> L_DB() throws ParseException {ArrayList<permisosUsr> lu = new ArrayList<permisosUsr>(); ArrayList<permisosUsr> lu2 = new ArrayList<permisosUsr>();
    lu = DB();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_DB_IZQ:{
      lu2 = L_DB();
for(int i=0; i < lu2.size(); i++){
                    lu.add(lu2.get(i));
                }
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      ;
    }
{if ("" != null) return lu;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<permisosUsr> DB() throws ParseException {Token n; ArrayList<String> lp = new ArrayList<String>();ArrayList<String> lf = new ArrayList<String>();ArrayList<String> lo = new ArrayList<String>();ArrayList<String> lt = new ArrayList<String>();
    jj_consume_token(T_DB_IZQ);
    jj_consume_token(T_NOMBRE_IZQ);
    n = jj_consume_token(ID);
    jj_consume_token(T_NOMBRE_DER);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TABLA_IZQ:{
      lt = L_TABLA();
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_OBJ_IZQ:{
      lp = L_OBJETO();
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_FUNC_IZQ:{
      lf = L_FUNC();
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_PROC_IZQ:{
      lp = L_PROC();
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    jj_consume_token(T_DB_DER);
ArrayList<permisosUsr> lu = new ArrayList<permisosUsr>();
                    lu.add(new permisosUsr(n.image, lt, lo, lf, lp));
                    {if ("" != null) return lu;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> L_TABLA() throws ParseException {ArrayList<String> lt, lt2;
    lt = TABLA();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TABLA_IZQ:{
      lt2 = L_TABLA();
for(int i=0; i < lt2.size(); i++){
                        lt.add(lt2.get(i));
                    }
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      ;
    }
{if ("" != null) return lt;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> TABLA() throws ParseException {ArrayList<String> lt; Token t;
    jj_consume_token(T_TABLA_IZQ);
    t = jj_consume_token(ID);
    jj_consume_token(T_TABLA_DER);
lt = new ArrayList<String>();
                                            lt.add(t.image);
                                            {if ("" != null) return lt;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> L_OBJETO() throws ParseException {ArrayList<String> lo, lo2;
    lo = OBJETO();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_OBJ_IZQ:{
      lo2 = L_OBJETO();
for(int i=0; i < lo2.size(); i++){
                            lo.add(lo2.get(i));
                        }
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      ;
    }
{if ("" != null) return lo;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> OBJETO() throws ParseException {ArrayList<String> lo; Token o;
    jj_consume_token(T_OBJ_IZQ);
    o = jj_consume_token(ID);
    jj_consume_token(T_OBJ_DER);
lo = new ArrayList<String>();
                                            lo.add(o.image);
                                            {if ("" != null) return lo;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> L_FUNC() throws ParseException {ArrayList<String> lf, lf2;
    lf = FUNC();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_FUNC_IZQ:{
      lf2 = L_FUNC();
for(int i=0; i < lf2.size(); i++){
                        lf.add(lf2.get(i));
                    }
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      ;
    }
{if ("" != null) return lf;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> FUNC() throws ParseException {ArrayList<String> lf; Token f;
    jj_consume_token(T_FUNC_IZQ);
    f = jj_consume_token(ID);
    jj_consume_token(T_FUNC_DER);
lf = new ArrayList<String>();
                                            lf.add(f.image);
                                            {if ("" != null) return lf;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> L_PROC() throws ParseException {ArrayList<String> lp, lp2;
    lp = PROC();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_PROC_IZQ:{
      lp2 = L_PROC();
for(int i=0; i < lp2.size(); i++){
                        lp.add(lp2.get(i));
                    }
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      ;
    }
{if ("" != null) return lp;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> PROC() throws ParseException {ArrayList<String> lp; Token p;
    jj_consume_token(T_PROC_IZQ);
    p = jj_consume_token(ID);
    jj_consume_token(T_PROC_DER);
lp = new ArrayList<String>();
                                            lp.add(p.image);
                                            {if ("" != null) return lp;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public usrGrammarTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2,0x6000000,0x6000000,0x8000,0x8000,0x800000,0x80000,0x20000,0x200000,0x800000,0x80000,0x20000,0x200000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public usrGrammar(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public usrGrammar(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new usrGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public usrGrammar(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new usrGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public usrGrammar(usrGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(usrGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[33];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 13; i++) {
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
    for (int i = 0; i < 33; i++) {
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
