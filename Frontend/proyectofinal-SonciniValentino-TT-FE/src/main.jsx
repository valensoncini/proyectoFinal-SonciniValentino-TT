import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { ArticulosProvider } from './contexts/ArticulosContext.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <ArticulosProvider>
    <App />
    </ArticulosProvider>
  </StrictMode>,
)
