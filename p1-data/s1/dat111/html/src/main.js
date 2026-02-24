////////////////////////////////////////////////////////////////////////////////
// three.js
////////////////////////////////////////////////////////////////////////////////
import * as THREE from 'three';
import { GLTFLoader } from 'three/addons/loaders/GLTFLoader.js';

// Sections
var sections = new Array('1', '2', '3', '4', '5', '6');

// Smoothstep function
function smoothstep( x ) {
  return x*x*x/(3.0*x*x-3.0*x+1.0);
}

// Scene setup
const scene = new THREE.Scene();

// Camera setup
var cameraDistance = 10;
var cameraRotationX = 0;
var cameraRotationY = 0;
const camera = new THREE.PerspectiveCamera( 30, 1, 0.01, 1000 );
camera.position.set( 0, 0, 10 );

// Renderer setup
const renderer = new THREE.WebGLRenderer( { alpha: true } );
renderer.setSize( 180, 180 );
document.getElementById('header').appendChild( renderer.domElement ); 

// Handle model loading
var objs = new Array();
const manager = new THREE.LoadingManager();
const loader = new GLTFLoader( manager );
function loadModel(filename, material, index) {
  loader.load( filename,
      function ( gltf ) {
        gltf.scene.traverse((child) => { if (child.isMesh) { child.geometry.center(); } });
        const gltfGeo = gltf.scene.children[0].geometry;
        const gltfWire = new THREE.WireframeGeometry( gltfGeo );
        objs[index] = new THREE.LineSegments( gltfWire, material );
        objs[index].rotation.x = Math.PI * 0.5;
        if (index != 0) { objs[index].visible = false; }
        scene.add ( objs[index] );
      }, 
      undefined, 
      function ( error ) {
        console.error( error );
      });
}

// Handle scrolling
var scrollPercents = new Array();
function scroll() {
  let scrollTop = window.scrollY;
  for (let i = sections.length-1; i >= 0; i--) {
    if (i == 0) {
      scrollPercents[i] = scrollTop < scrollSections[i] ? 0.5 : scrollTop > scrollSections[i+1] ? 1 : ( (scrollTop - scrollSections[i]) / (scrollSections[i+1] - scrollSections[i]) ) / 2 + 0.5;
    } else if (i == sections.length - 1) {
      scrollPercents[i] = scrollTop < scrollSections[i-1] ? 0 : scrollTop <= scrollSections[i] ? (scrollTop - scrollSections[i-1]) / (scrollSections[i] - scrollSections[i-1]) * 0.5 : 0.5;
    } else {
      scrollPercents[i] = scrollTop < scrollSections[i-1] ? 0 : scrollTop > scrollSections[i+1] ? 1 : scrollTop <= scrollSections[i] ? (scrollTop - scrollSections[i-1]) / (scrollSections[i] - scrollSections[i-1]) * 0.5 : (scrollTop - scrollSections[i]) / (scrollSections[i+1] - scrollSections[i]) * 0.5 + 0.5;
    }
    if (objs[i] != null) {
      scrollPercents[i] = smoothstep(scrollPercents[i]);
      if (scrollPercents[i] < 0.01 || scrollPercents[i] > 0.99) {
        objs[i].visible = false;
      } else { 
        objs[i].visible = true;
        objs[i].rotation.x = Math.PI * scrollPercents[i];
        objs[i].material.opacity = scrollPercents[i] <= 0.5 ? scrollPercents[i] * 2 : 1 - ((scrollPercents[i] - 0.5) * 2);
      }
    }
  }
}

// Refresh sections on startup & window resize
addEventListener("resize", (event) => { sectionsRefresh(); })
manager.onLoad = function ( ) { console.log( 'Model loading complete.'); sectionsRefresh(); };
function sectionsRefresh() {
  var lastSectionCheck = window.innerHeight - document.getElementById('footer').getBoundingClientRect().height - document.getElementById(sections[sections.length-1]).getBoundingClientRect().height;
  for (let i = 0; i < sections.length; i++) {
    scrollSections[i] = document.getElementById(sections[i]).getBoundingClientRect().top + window.scrollY;
    if (i == sections.length-1 && lastSectionCheck > 0) { scrollSections[i] -= lastSectionCheck; }
  }
  scroll();
}

// Document load
var scrollSections = new Array();
window.addEventListener('load', (event) => {
  console.log('The page has loaded.');
  for (let i = 0; i < sections.length; i++) {
    loadModel('./' + sections[i] + '.glb', new THREE.LineBasicMaterial( { color: 0x262626, transparent: true } ), i);
  }
  document.body.onscroll = scroll;
});

// Render the scene
var clock = new THREE.Clock();
var time = 0;
var dt = 0;
function animate() {
  dt = clock.getDelta();
  time += dt;
  time %= Math.PI * 2;
  cameraRotationX %= Math.PI * 2;
  camera.position.x = cameraDistance * Math.sin( cameraRotationX ) * Math.cos(cameraRotationY);
  camera.position.y = cameraDistance * Math.sin( cameraRotationY );
  camera.position.z = cameraDistance * Math.cos( cameraRotationX ) * Math.cos(cameraRotationY);
  cameraRotationX += (1 + Math.abs(Math.sin(time * 0.5)) * Math.PI) * dt;
  camera.lookAt( 0, 0, 0 );
  renderer.render( scene, camera );
}
renderer.setAnimationLoop( animate );


////////////////////////////////////////////////////////////////////////////////
// highlight.js
////////////////////////////////////////////////////////////////////////////////
import hljs from 'highlight.js/lib/core';
import java from 'highlight.js/lib/languages/java';
hljs.registerLanguage('java', java);
hljs.highlightAll();


////////////////////////////////////////////////////////////////////////////////
// Chart.js
////////////////////////////////////////////////////////////////////////////////
import Chart from 'chart.js/auto';

const data1 = {
  labels: [
    'Januar',
    'Februar',
    'Mars',
    'April',
    'Mai',
    'Juni',
    'Juli',
    'August',
    'September',
    'Oktober',
    'November',
    'Desember',
  ],
  datasets: [{
    label: '2023',
    data: [297.8, 260.1, 181.0, 42.8, 81.9, 67.8, 221.9, 267.5, 327.0, 219.2, 81.5, 255.8],
    fill: false,
    borderColor: '#5F87AF',
    borderWidth: 2,
    pointStyle: false,
  }] 
};

const data2 = {
  labels: [
    'Januar',
    'Februar',
    'Mars',
    'April',
    'Mai',
    'Juni',
    'Juli',
    'August',
    'September',
    'Oktober',
    'November',
    'Desember',
  ],
  datasets: [{
    label: '2024',
    data: [209.7, 335.1, 163.0, 102.3, 61.5, 172.1, 151.8, 473.4, 164.0, 257.9, 250.2, 465.1],
    fill: false,
    borderColor: '#5F87AF',
    borderWidth: 2,
    pointStyle: false,
    pointHitRadius: 10,
  }] 
};

const data3 = {
  labels: [1950, 1951, 1952, 1953, 1954, 1955, 1956, 1957, 1958, 1959, 1960, 1961, 1962, 1963, 1964, 1965, 1966, 1967, 1968, 1969, 1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025],
  datasets: [{ 
      data: [2250.9, 1722.8, 1819.4, 2537.1, 2111.2, 1813.5, 1921.3, 2379.3, 1706.6, 1536.7, 1418.9, 1916.8, 2044.1, 1699.3, 2349.6, 1491.4, 2035.8, 3068.2, 1585.0, 1942.3, 2001.3, 2343.2, 1918.7, 2724.2, 2071.3, 2641.4, 1450.6, 1745.5, 1830.3, 2346.9, 2020.3, 2319.8, 2508.5, 2899.2, 1760.4, 1966.0, 2778.8, 1710.1, 2341.7, 2867.2, 2992.0, 2428.5, 3019.9, 1843.8, 2549.3, 2642.5, 1689.1, 2159.1, 2444.7, 2818.5, 2395.9, 2089.7, 2058.8, 2628.7, 2592.1, 3051.8, 2512.9, 3018.1, 2553.6, 2092.5, 1624.1, 2682.5, 2632.7, 2469.5, 2428.6, 3101.7, 2454.8, 3091.4, 2386.9, 2346.7, 3054.8, 2160.9, 2447.5, 2304.3, 2806.1],
      label: "Nedbør",
      fill: false,
      //backgroundColor: "#5F87AF",
      borderColor: "#5F87AF",
      //borderDash: [3, 1],
      borderWidth: 1.5,
      pointStyle: false,
      pointHitRadius: 10,
      cubicInterpolationMode: 'monotone',
      tension: 0.2,
      stepped: 'middle',
    }
  ]
}

const options1 = {
  animation: {
    duration: 0
  },
  scales: {
      r: {
          angleLines: {
              display: false
          },
          min: 50,
          suggestedMax: 500
      }
  },
  plugins: {
      legend: {
        display: false
      },
      tooltip: {
        backgroundColor: "#FFFFFF",
        borderColor: "#6C6C6C",
        borderWidth: 1,
        titleColor: "#6C6C6C",
        titleAlign: "center",
        bodyColor: "#6C6C6C",
        bodyAlign: "center",
        cornerRadius: 0,
        displayColors: false,
        callbacks: {
          label: function(context) {
            return context.parsed.r + " mm";
          },
        },
      },
    }
};

new Chart(document.getElementById("chartRadar1"), {
  type: 'radar',
  data: data1,
  options: options1,
});

new Chart(document.getElementById("chartRadar2"), {
  type: 'radar',
  data: data2,
  options: options1,
});

const options2 = {
  indexAxis: 'x',
  animation: {
    duration: 0
  },
  scales: {
    y: {
      //beginAtZero: true
    },
  },
  plugins: {
      legend: {
        display: false
      },
      tooltip: {
        backgroundColor: "#FFFFFF",
        borderColor: "#6C6C6C",
        borderWidth: 1,
        titleColor: "#6C6C6C",
        titleAlign: "center",
        bodyColor: "#6C6C6C",
        bodyAlign: "center",
        cornerRadius: 0,
        displayColors: false,
        callbacks: {
          label: function(context) {
            return context.parsed.y + " mm";
          },
        },
      },
    }
};
new Chart(document.getElementById("chartLine1"), {
  type: 'line',
  data: data3,
  options: options2,
});

