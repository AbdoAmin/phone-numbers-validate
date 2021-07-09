import './App.css';
import PaginationTable from "./component/PaginationTable/PaginationTable";
import Autocomplete from "@material-ui/lab/Autocomplete";
import TextField from "@material-ui/core/TextField";
import React, {useEffect} from "react";


const countries = [
    'Cameroon',
    'Ethiopia',
    'Morocco',
    'Mozambique',
    'Uganda'
];

const App = () => {
    const [country, setCountry] = React.useState("");
    const [status, setStatus] = React.useState("");

    return (
        <div>
            <div style={{margin: 'auto',display: 'table'}}>
                <Autocomplete
                    id="countryFilter"
                    options={countries}
                    style={{width: 300, display: 'inline-block', margin: '10px'}}
                    renderInput={(params) => <TextField {...params} label="Country" variant="outlined"/>}
                    onChange={(event, value) => setCountry(value)}
                />
                <Autocomplete
                    id="statusFilter"
                    options={['Valid', 'Not Valid', 'All']}
                    style={{width: 300, display: 'inline-block', margin: '10px'}}
                    disabled={!country}
                    renderInput={(params) => <TextField {...params} label="Status" variant="outlined"/>}
                    onChange={(event, value) => setStatus(value)}
                />
            </div>
            <PaginationTable country={country} status={status}/>
        </div>
    );
}

export default App;

