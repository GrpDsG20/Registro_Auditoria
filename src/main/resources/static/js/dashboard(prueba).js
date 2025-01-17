// Datos de ejemplo para los gráficos
const datosEstudiantes = {
  labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio'],
  datasets: [{
    label: 'Estudiantes Registrados',
    data: [120, 150, 180, 200, 190, 210],
    backgroundColor: 'rgba(54, 162, 235, 0.5)',
    borderColor: 'rgba(54, 162, 235, 1)',
    borderWidth: 1
  }]
};

const datosCalificaciones = {
  labels: ['Matemáticas', 'Ciencias', 'Historia', 'Inglés', 'Arte'],
  datasets: [{
    label: 'Calificaciones Promedio',
    data: [85, 78, 92, 88, 76],
    backgroundColor: 'rgba(255, 99, 132, 0.5)',
    borderColor: 'rgba(255, 99, 132, 1)',
    borderWidth: 1
  }]
};

// Configuración de los gráficos
const opcionesGrafico = {
  responsive: true
};

// Creación de los gráficos
const graficoEstudiantes = document.getElementById('graficoEstudiantes').getContext('2d');
new Chart(graficoEstudiantes, {
  type: 'bar',
  data: datosEstudiantes,
  options: opcionesGrafico
});

const graficoCalificaciones = document.getElementById('graficoCalificaciones').getContext('2d');
new Chart(graficoCalificaciones, {
  type: 'bar',
  data: datosCalificaciones,
  options: opcionesGrafico
});
