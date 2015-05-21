* Implementación de Caché:   EhCache

*** Hacemos las peticiones desde el Navegador. Mostrará un error (No message available)

Primera petición (No cacheada): http://localhost:8080/query/data
  
  * En línea de comandos:  
        getData
        Controller/getData datos   Time=5000
        
Nueva petición (* cacheada):    http://localhost:8080/query/data

  * En línea de comandos: 
        getDatda
        Controller/getData datos   Time=0
        
http://localhost:8080/query/flush

  * En línea de comandos:
        flushData
        All caches have been completely flushed
