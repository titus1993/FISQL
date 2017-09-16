from __future__ import unicode_literals

# Create your views here.
from django.http import JsonResponse
from django.shortcuts import render

from fisql.Socket.socket import SocketClient


def index(request):
    return render(request, 'fisql/index.html')



def ejecutarSQL(request):
    codigo = request.POST['usqlCode']
    s = SocketClient()
    respuesta = s.sendToServer(codigo)

    return JsonResponse({
        'salida' : respuesta + '\n'
    })