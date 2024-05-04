const conexionDb = function () { }
const { MongoClient } = require('mongodb');

const url = 'mongodb://localhost:27017'; 


const dbName = 'festivos'; 
const collectionName='tipos';

const client = new MongoClient(url, { directConnection: true,
  serverApi: {
    version: "1",
    strict: true,
    deprecationErrors: true,
  } });


conexionDb.buscar= async function (tipo,varDia,varMes) {
  try {
    
    await client.connect();
    console.log('Conexión establecida correctamente');

   
    const db = client.db(dbName);
    const collection = db.collection(collectionName);
    const filtro = {id:tipo,
      "festivos": {
          $elemMatch: { "dia": varDia, "mes": varMes }
      }
  };

  return  await collection.findOne(filtro);

  } catch (error) {
    console.error('Error al conectar a la base de datos', error);
  } finally {
    
    await client.close();
    console.log('Conexión cerrada');
  }
}

module.exports = conexionDb;