import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css';
import Home from './assets/components/Home/Home';
import Signup  from './assets/components/Auth/Signup/Signup';
import NoPage from './assets/components/NoPage/NoPage';
import Login from './assets/components/Auth/Login/Login';

function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Home />}/>
          <Route path="/signup" element={<Signup />} />
          <Route path='*' element={<NoPage />} />
          <Route path="/login" element={<Login />} />
          {/*<Route path="/dashboard" element={<Dashboard />} />
             
          
          <Route path='/policies' element={<Policies />}/>
          <Route path='/pricing' element={<Pricing />} /> */}

          
        </Routes>
      </BrowserRouter>
    </>
  )
}
export default App
