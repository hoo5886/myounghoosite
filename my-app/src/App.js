import React  from 'react';
import Home from "./pages/Home";
import './App.css'
import {Link, Route, Routes} from "react-router-dom";
import MyHeader from "./components/MyHeader";
import MySidebar from "./components/MySidebar";
import Page from "./pages/page";

function App() {
  /*
  const [message, setMessage] = useState([]);
  useEffect(() => {
    fetch("/board/hello")
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      setMessage(data);
    });
  }, []);
  */
  return (
      <div className="App appContainer">
        <MyHeader/>
        <div style={{display: 'flex', flexDirection: 'row'}}>
          <MySidebar/>
          <Routes>
            <Route path="/board/main" element={<Home/>} />
            <Route path="/board/:boardId" element={<Page/>} />
          </Routes>
        </div>
      </div>
  );
}

export default App;