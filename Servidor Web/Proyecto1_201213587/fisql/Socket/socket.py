import socket               # Import socket module

class SocketClient:

    def sendToServer(self, message):
        s = socket.socket()         # Create a socket object
        host = socket.gethostname() # Get local machine name
        port = 5000                # Reserve a port for your service.

        s.connect((host, port))
        while 1:
            data = s.recv(5000)
            print(s.recv(5000))
            s.send("message processed.."+'\n')

            s.close

            return data.decode(encoding='UTF-8')


#import socket


#class SocketClient:

#    TCP_IP = '127.0.0.1'
#    TCP_PORT = 9770
#    BUFFER_SIZE = 104857600

#    def sendToServer(self, message):
#        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#        s.connect((self.TCP_IP, self.TCP_PORT))
#        s.sendall((message+"\n").encode(encoding='UTF-8'))
#        s.sendall(('§§§\n'.encode(encoding='utf_8')))
#        data = s.recv(self.BUFFER_SIZE)
#        print('Data recibida: _'+data.decode(encoding='UTF-8')+'_')
#        s.close()
#        return data.decode(encoding='UTF-8')


