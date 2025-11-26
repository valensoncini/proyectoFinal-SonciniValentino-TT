import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, Router, Routes } from 'react-router-dom'
import ArticulosMain from './components/ArticulosMain'

function App() {


  return (
      
    <ArticulosMain/>
    
  )
}

export default App


/*
<Router>
        <>
        <Routes>
          <Route  path='/articulos' element={<ArticulosMain/>}/>
        </Routes>
        </>
    </Router>*/