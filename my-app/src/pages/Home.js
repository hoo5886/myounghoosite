import {useEffect, useState} from "react";
import { Link } from 'react-router-dom';
import style from "./home.module.css";

const Home = () => {
  const [boardlist, setBoardlist] = useState([]);

  useEffect(() => {
    fetch('/board/main')
    .then(response => response.json())
    .then(data => {console.log(data); setBoardlist(data)})
    .then(err => console.log(err));
  },[])

  return (
      <div className="Boardlist">
          {
            boardlist.map((board, index) =>
              <Link to={`/board/${board.boardId}`} key={index} className={style.boardItem} >
                <span>{board.title}</span>
                &nbsp;
                <span>{board.regDate}</span>
              </Link>
            )
          }
      </div>
  )
}
export default Home;