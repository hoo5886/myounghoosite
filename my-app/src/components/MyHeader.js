import * as React from 'react';
import {Button, AppBar, Toolbar, Typography} from "@mui/material";
import '../App.css';

const MyHeader = (props) => {
  const { history } = props;
  const [anchorEl, setAnchorEl] = React.useState(null);

  const handleMenu = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleMenuClick = (pageURL) => {
    history.push(pageURL);
    setAnchorEl(null);
  };

  const handleButtonClick = (pageURL) => {
    history.push(pageURL);
  };

  return (
      <div>
        <AppBar position='static' style={{ background: '#2b2b30' }}>
          <Toolbar>
            <Typography variant="h6">
              개인 사이트
            </Typography>
            <div className="btn-container">
              <Button className="home"
                  variant="contained"
                  onClick={() => handleButtonClick("/")}
              >
                HOME
              </Button>

              <Button className="login"
                      variant="contained"
                onClick={()=> handleButtonClick("/login")}
              >
                login
              </Button>

              <Button className="about"
                  variant="contained"
                  onClick={() => handleButtonClick("/about")}
              >
                ABOUT
              </Button>
            </div>
          </Toolbar>
        </AppBar>
      </div>
  )
}

export default MyHeader;