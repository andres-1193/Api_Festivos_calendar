//constructor
const fechas = function () { }

// metodo para calcular la fecha de la semana santa
fechas.ObtenerInicioSemanaSanta = function (año) {

    a = año % 19;
    b = año % 4;
    c = año % 7;
    d = (19 * a + 24) % 30;
    dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;
    dia = 15 + dias;
    mes = 3;
    if (dia > 31) {
        dia = dia - 31
        mes = 4;

    }
    return new Date(año, mes - 1, dia);
}
// metodo para agregar a una fecha, un numero de dias
fechas.agregarDias=function(fecha,dias){
//obtener la nueva fecha
const nuevaFecha=new Date(fecha.getTime() + dias * 24 * 60 * 60 * 1000);
return nuevaFecha;

}


//metodo para obtener la fecha del siguiente lunes de un festivo determinado

fechas.siguienteLunes = function (fechas) {
    // obtener dia de la semana
    const diaSemana = fecha.getDay();//domingo inicia desde 0 y lunes 1

    // Calcular dias que faltan para el siguiente lunes

    const diaLunes = (8 - diaSemana) % 7;

    // Obtener la nueva fecha

    const fechaLunes = this.agregarDias(fecha, diaLunes)


    return fechaLunes;

}

module.exports = fechas;