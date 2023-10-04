import {useEffect, useState} from "react";
import style from "./home.module.css"
import MyHeader from "../components/MyHeader";
import MySidebar from "../components/MySidebar";

const Page = () => {
  const [page, setPage] = useState("");

  useEffect(() => {
    fetch('/board/${boardId}')
    .then(response => response.json())
    .then(data => {console.log(data); setPage(data)})
    .then(err => console.log(err));
  },[])

  return (
      <div className="page">
        {
          page.map((p, index) =>
            <div key={index}>
              <div>{p.title}</div>
              <div>{p.content}</div>
              <div>{p.regDate}</div>
            </div>
          )
        }
      </div>
  )
}

export default Page;