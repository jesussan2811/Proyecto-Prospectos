const express = require('express');
const mysql = require('mysql');
const Connection = require('mysql/lib/Connection');
const cors = require('cors')

// const bodyParser = require('body-parser');

const PORT = process.env.PORT || 4040;

const app = express();


app.use(express.json());
app.use(cors());

// MySQL
const conexion = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'heroineX10',
  database: 'PRUEBA'
});
// checar conexion
conexion.connect(error => {
  if (error) throw error;
  console.log('conexion ok')
});
//listen to port
app.listen(PORT, () =>
  console.log(`Server en el puerto ${PORT}`));

//RUTAS
app.get('/', (req, res) => {
    res.send('Hola, si funciono');
});
//GET prospectos
app.get('/allProspectos', (req, res) => {
    const query = 'select * from PROSPECTOS;';
    
    conexion.query(query, (error, results) => {
        if (error) throw error;
        if (results.length > 0) {
            res.json(results);
        } else {
            res.send([]);
        }
    });
})

//GET prospecto con ID
app.get('/prospectos/:id', (req, res) => {
    const { id } = req.params;
    const query = 
    `select Nombre,ApellidoPat,ApellidoMat,Calle,NoCasa,Colonia,CP,Telefono,RFC,Estatus from PROSPECTOS where p.ID = ${id}`;

    conexion.query(query, (error, results) => {
        if (error) throw error;
        if (results.length > 0) {
            res.json(results);
        } else {
            res.send('Empty')
        }
    });
});

//Post prospecto
app.post('/addProspecto', (req, res) => {
    const query = 'INSERT INTO PROSPECTOS SET ?';

    const prospectoObj = {
        Nombre:req.body.Nombre,
        ApellidoPat:req.body.ApellidoPat,
        ApellidoMat:req.body.ApellidoMat,
        Calle:req.body.Calle,
        NoCasa:req.body.NoCasa,
        Colonia:req.body.Colonia,
        CP:req.body.CP,
        Telefono:req.body.Telefono,
        RFC:req.body.RFC,
        Estatus:req.body.Estatus
    }
    conexion.query(query,prospectoObj,error => {
        if (error) throw error;
        
        res.send(prospectoObj);
      });
    
});


//UPDATE al estatus de un prospecto
app.put('/prospectos/update/:id', (req, res) => {
    console.log("si entro");
    const { id } = req.params;
    const { estatus,observaciones } = req.body;
    console.log(estatus);
    const query = `UPDATE PROSPECTOS set Estatus = '${estatus}',Observaciones = '${observaciones}' where ID = ${id}`;

    conexion.query(query,error => {
        if (error) throw error;
        res.send({mensaje:'Evaluado'});
    });
});