# Yacc example

from fisql.Analisis.Gramatica.ply import yacc as yacc
from fisql.Analisis.Gramatica.Paquete import Paquete

# Get the token map from the lexer.  This is required.
from fisql.Analisis.Gramatica.Lexico import tokens

paquetones = []

def p_plycs(p):
    '''plycs : lpaquete'''
    p[0] = paquetones

def p_lpaquete(p):
    '''lpaquete : paquete lpaquete
                | '''
    if len(p) == 3:
        paquetones.append(p[1])
        print('agrego paquete')
    else:
        paquetones.clear()

def p_paquete(p):
    'paquete : COR_A PAQUETE DPTOS tipo MENSAJE DPTOS CADENA COR_C'
    e = Paquete()
    e.Tipo = p[4]
    e.Mensaje = p[7]
    p[0] = e

def p_tipo(p):
    '''tipo : USQL
            | REPORTE
            | ERROR
            | EJECUCION
            | HISTORIAL
            | BACUP
            | LOGIN'''
    p[0] = p[1]

# Error rule for syntax errors
def p_error(p):
    print("Syntax error in input!")

# Build the parser
parser = yacc.yacc()