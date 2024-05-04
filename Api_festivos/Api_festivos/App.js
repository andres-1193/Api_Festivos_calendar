const express=require('express');
const app=express();
const conexionDb  = require('./Repositorios/conexionDb');

app.get('/festivos/verificar/:anio/:mes/:dia',(req,res)=>{
    const anio=+req.params.anio;
    const mes=+req.params.mes;
    const dia=+req.params.dia;
    var respuesta="";

    conexionDb.buscar(1,dia,mes).then((resultado) => { 
        if (!!resultado){
            respuesta="Es Festivo";
            res.send(respuesta);
        }else{
            const fecha = new Date(anio.toString()+"-"+mes.toString()+"-"+dia.toString());
            const diaSemana = fecha.getDay();

            if(diaSemana===1){
                conexionDb.buscar(2,dia,mes).then((resultado) => {
                    if (!!resultado){
                        respuesta="Es Festivo";
                        res.send(respuesta);
                    }else{                    
                       respuesta="No es Festivo"; 
                       res.send(respuesta); 
                    }
                    
                })
                .catch((error) => {
                  respuesta="error al consultar en base de datos";
                  res.send(respuesta);
                });

            }else{
                conexionDb.buscar(2,dia,mes).then((resultado) => {
                    if (!!resultado){
                        respuesta="Es Festivo";
                        res.send(respuesta);
                    }else{                    
                        respuesta="No es Festivo";
                        res.send(respuesta);
                    }
                    
                })
                .catch((error) => {
                  respuesta="error al consultar en base de datos";
                  res.send(respuesta);
                });
            }
            
        }
        
       
        res.send(respuesta);
      })
      .catch((error) => {
        respuesta="error al consultar en base de datos";
        res.send(respuesta);

      });

      

    
});

const puerto=3030;
app.listen(puerto, ()=>{
    console.log(`API escuchando por el puerto ${puerto}`)
});