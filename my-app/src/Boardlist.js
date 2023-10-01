import React, {  useEffect,useState } from 'react';

function Boardlist() {
  const [board, setBoard] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/board')
    .then(response => response.json())
    .then(data => setBoard(data._embedded.board))
    .catch(err => console.error(err));
  }, []);

  return (
      <div>
        <table>
          <tbody>
          {
            board.map((board, index) => <tr key={index}>
              <td>{board.boardType}</td>
              <td>{board.title}</td>
              <td>{board.content}</td>
              <td>{board.regDate}</td>
            </tr>)
          }
          </tbody>
        </table>
      </div>
  );
}

export default Boardlist;