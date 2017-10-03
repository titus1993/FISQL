from fisql.Analisis.Gramatica.ply import lex as lex
# List of token names.   This is always required
tokens = (
   'COR_A',
   'COR_C',
   'DPTOS',
   'PAQUETE',
   'USUARIO',
   'PASSWORD',
   'LOGIN',
   'ERROR',
   'HISTORIAL',
   'EJECUCION',
   "MENSAJE",
   "USQL",
   'REPORTE',
   'CADENA',
   'BACUP'
)

# Regular expression rules for simple tokens
t_COR_A = r'\['
t_COR_C = r'\]'
t_DPTOS = r':'
t_PAQUETE = r'paquete'
t_USUARIO = r'usuario'
t_PASSWORD = r'password'
t_LOGIN = r'login'
t_ERROR = r'error'
t_MENSAJE = r'mensaje'
t_USQL = r'usql'
t_REPORTE = r'reporte'
t_HISTORIAL = r'historial'
t_EJECUCION = r'ejecucion'
t_BACUP = r'bacup'


# A regular expression rule with some action code
def t_CADENA(t):
	r'§[^§]*§'
	return t

# Define a rule so we can track line numbers
def t_newline(t):
    r'\n+'
    t.lexer.lineno += len(t.value)

# A string containing ignored characters (spaces and tabs)
t_ignore  = ' \t'

# Error handling rule
def t_error(t):
    print("Caracter invalido '%s'" % t.value[0])
    t.lexer.skip(1)

# Build the lexer
lexer = lex.lex()