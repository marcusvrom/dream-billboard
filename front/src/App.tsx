import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Footer from './components/Footer/Footer';
import Navbar from './components/Navbar/Navbar';
import DreamForm from './pages/DreamForm/DreamForm';
import ListById from './pages/ListById/ListById';
import Listing from './pages/Listing/Listing';


function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Listing />}/>
        <Route path="/new/dream" element={<DreamForm />}/>
        <Route path="/dream">
          <Route path=":dreamId" element={<ListById />}/>
        </Route>
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
