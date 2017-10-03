from __future__ import unicode_literals
import socket
# Create your views here.
from django.http import JsonResponse
from django.shortcuts import render, redirect
from django.views.decorators.csrf import csrf_exempt

from fisql.Socket.socket import SocketClient

from fisql.Analisis.Gramatica.Paquete import Paquete

from fisql.Analisis.Gramatica.Sintactico import parser

def index(request):
    # leer cookie
    if (not request.session.get('login', False)):
        # si no hay login redireccionar a login
        return redirect('login')
    return render(request, 'fisql/index.html', {'user': request.session['login'], 'admin': request.session['admin']})



def ejecutarSQL(request):
    codigo = '[paquete:instruccion\n'
    codigo += 'instruccion:§'
    codigo += request.POST['usqlCode']
    codigo += '\n§]'

    respuesta = comunicarse(codigo)

    mensaje = ''
    historial = ''
    ejecucion = ''
    reporte = ''

    for p in respuesta:
        if p.Tipo == 'usql':
            mensaje += str(p.Mensaje[1:-1])
        elif p.Tipo == 'reporte':
            reporte += str(p.Mensaje[1:-1]) + "§"
        elif p.Tipo == 'historial':
            historial += str(p.Mensaje[1:-1])
        elif p.Tipo == 'ejecucion':
            ejecucion += str(p.Mensaje[1:-1])

    print(respuesta)
    return JsonResponse({
        'mensaje' : mensaje + '\n',
        'historial' : historial + '\n',
        'ejecucion' : ejecucion + '\n',
        'reporte' : reporte
    })

def ejecutarBacup(request):
    codigo = '[paquete:bacup]'

    respuesta = comunicarse(codigo)


    mensaje = ''

    for p in respuesta:
        mensaje += str(p.Mensaje[1:-1])

    return JsonResponse({
        'mensaje' : mensaje
    })

def ejecutarRestaurar(request):
    codigo = '[paquete:restaurar\n'
    codigo += 'instruccion:§'
    codigo += request.POST['codigo']
    codigo += '\n§]'

    comunicarse(codigo)



def ejecutarReporte(request):
    codigo = '[paquete:reporte\n'
    codigo += 'instruccion:§'
    codigo += request.POST['reporteCode']
    codigo += '\n§]'

    respuesta = comunicarse(codigo)

    mensaje = ''
    historial = ''
    ejecucion = ''
    reporte = ''

    for p in respuesta:
        if p.Tipo == 'usql':
            mensaje += str(p.Mensaje[1:-1])
        elif p.Tipo == 'reporte':
            reporte += str(p.Mensaje[1:-1])
        elif p.Tipo == 'historial':
            historial += str(p.Mensaje[1:-1])
        elif p.Tipo == 'ejecucion':
            ejecucion += str(p.Mensaje[1:-1])

    print(respuesta)
    return JsonResponse({
        'mensaje' : mensaje + '\n',
        'historial' : historial + '\n',
        'ejecucion' : ejecucion + '\n',
        'reporte' : reporte
    })

@csrf_exempt
def login(request):
    request.session['login'] = ''
    request.session['admin'] = ''
    if request.method == 'GET':
        return render(request, 'fisql/login.html')
    elif request.method == 'POST':
        #confirmar datos en el server
        user = request.POST.get('user', 'admin') #request.POST['user']
        contra = request.POST.get('password', 'admin') #request.POST['password']

        print(user + contra)
        if user == 'admin' and contra == 'admin':
            print('Login exitoso')
            #establecer cookie
            request.session['login'] = user
            request.session['admin'] = 'true'
            return redirect('index')
        else:
            return redirect('login')

def comunicarse(cadena):
    resultado = ''
    socket1 = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    HOST = socket.gethostname()
    PORT = 5000
    socket1.connect((HOST, PORT))
    bytes_cadena = str.encode(cadena)
    socket1.send(bytes_cadena)
    cond = True
    while cond:
        CadenaRecServidor = socket1.recv(50000)
        devuelto = CadenaRecServidor.decode()
        if devuelto[:13] == '[paquete:fin]':
            break

        c = Paquete()
        c.Tipo = 'incompleto'
        #a = parser.parse(devuelto + '\n')
        #if a:
        #    paquetes.append(a)
        #else:
         #   paquetes.append(c)
        #print('Paquete: ' + devuelto + ' ...')

        resultado += devuelto

    paquetes = parser.parse(resultado)
    socket1.close()
    print(resultado)




    print('Termino la comunicacion!')
    return paquetes



