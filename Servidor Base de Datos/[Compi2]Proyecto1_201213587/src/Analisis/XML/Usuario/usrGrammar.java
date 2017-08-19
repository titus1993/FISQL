/* usrGrammar.java */
/* Generated By:JavaCC: Do not edit this line. usrGrammar.java */
package Analisis.XML.Usuario;

public class usrGrammar implements usrGrammarConstants {
  public static void main(String args[]) throws ParseException {
    usrGrammar parser = new usrGrammar(System.in);
    parser.S();
  }

  final public void S() throws ParseException {
System.out.println("Comienza!!");
    L_USR();
System.out.println("Exito!!");
  }

  final public void L_USR() throws ParseException {
    USR();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_USR_IZQ:{
      L_USR();
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
  }

  final public void USR() throws ParseException {
    jj_consume_token(T_USR_IZQ);
    NOMBRE();
    PASS();
    TIPO();
    ESTADO();
    SESION();
    PERMISOS();
    jj_consume_token(T_USR_DER);
  }

  final public void NOMBRE() throws ParseException {
    jj_consume_token(T_NOMBRE_IZQ);
    jj_consume_token(ID);
    jj_consume_token(T_NOMBRE_DER);
  }

  final public void PASS() throws ParseException {
    jj_consume_token(T_PASS_IZQ);
    jj_consume_token(CADENA);
    jj_consume_token(T_PASS_DER);
  }

  final public void TIPO() throws ParseException {
    jj_consume_token(T_TIPO_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_ADMIN:{
      jj_consume_token(T_ADMIN);
      break;
      }
    case T_USER:{
      jj_consume_token(T_USER);
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(T_TIPO_DER);
  }

  final public void ESTADO() throws ParseException {
    jj_consume_token(T_ESTADO_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_ACTIVO:{
      jj_consume_token(T_ACTIVO);
      break;
      }
    case T_INACTIVO:{
      jj_consume_token(T_INACTIVO);
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(T_ESTADO_DER);
  }

  final public void SESION() throws ParseException {
    jj_consume_token(T_SESION_IZQ);
    jj_consume_token(CADENA);
    jj_consume_token(T_SESION_DER);
  }

  final public void PERMISOS() throws ParseException {
    jj_consume_token(T_PERMISOS_IZQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_DB_IZQ:{
      L_DB();
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(T_PERMISOS_DER);
  }

  final public void L_DB() throws ParseException {
    DB();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_DB_IZQ:{
      L_DB();
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      ;
    }
  }

  final public void DB() throws ParseException {
    jj_consume_token(T_DB_IZQ);
    jj_consume_token(T_NOMBRE_IZQ);
    jj_consume_token(ID);
    jj_consume_token(T_NOMBRE_DER);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TABLA_IZQ:{
      L_TABLA();
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_OBJ_IZQ:{
      L_OBJETO();
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_FUNC_IZQ:{
      L_FUNC();
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_PROC_IZQ:{
      L_PROC();
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    jj_consume_token(T_DB_DER);
  }

  final public void L_TABLA() throws ParseException {
    TABLA();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_TABLA_IZQ:{
      L_TABLA();
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      ;
    }
  }

  final public void TABLA() throws ParseException {
    jj_consume_token(T_TABLA_IZQ);
    jj_consume_token(ID);
    jj_consume_token(T_TABLA_DER);
  }

  final public void L_OBJETO() throws ParseException {
    OBJETO();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_OBJ_IZQ:{
      L_OBJETO();
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      ;
    }
  }

  final public void OBJETO() throws ParseException {
    jj_consume_token(T_OBJ_IZQ);
    jj_consume_token(ID);
    jj_consume_token(T_OBJ_DER);
  }

  final public void L_FUNC() throws ParseException {
    FUNC();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_FUNC_IZQ:{
      L_FUNC();
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      ;
    }
  }

  final public void FUNC() throws ParseException {
    jj_consume_token(T_FUNC_IZQ);
    jj_consume_token(ID);
    jj_consume_token(T_FUNC_DER);
  }

  final public void L_PROC() throws ParseException {
    PROC();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case T_PROC_IZQ:{
      L_PROC();
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      ;
    }
  }

  final public void PROC() throws ParseException {
    jj_consume_token(T_PROC_IZQ);
    jj_consume_token(ID);
    jj_consume_token(T_PROC_DER);
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
      jj_la1_0 = new int[] {0x2,0x18000000,0x6000000,0x8000,0x8000,0x800000,0x80000,0x20000,0x200000,0x800000,0x80000,0x20000,0x200000,};
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
    boolean[] la1tokens = new boolean[35];
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
    for (int i = 0; i < 35; i++) {
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
